package rpc.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable {
	final Selector selector;
	final ServerSocketChannel serverSocket;
	final static int PORT = 8080;
	final static int MAXIN = 1000;
	final static int MAXOUT = 1000;

	Reactor(int port) throws IOException {
		selector = Selector.open();
		serverSocket = ServerSocketChannel.open();
		serverSocket.socket().bind(new InetSocketAddress(PORT));
		serverSocket.configureBlocking(false);
		SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
		sk.attach(new Acceptor());
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				selector.select();
				Set selected = selector.selectedKeys();
				Iterator it = selected.iterator();
				while (it.hasNext()) {
					dispatch((SelectionKey) it.next());
					selected.clear();
				}
			}
		} catch (IOException ex) {
		}
	}

	private void dispatch(SelectionKey k) {
		Runnable r = (Runnable) (k.attachment());
		if (r != null) {
			r.run();
		}

	}

	class Acceptor implements Runnable {

		@Override
		public void run() {
			try {
				SocketChannel c = serverSocket.accept();
				if (c != null) {
					new Handler(selector, c);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	final class Handler implements Runnable {
		final SocketChannel socket;
		final SelectionKey sk;
		ByteBuffer input = ByteBuffer.allocate(MAXIN);
		ByteBuffer output = ByteBuffer.allocate(MAXOUT);
		static final int READING = 0, SENDING = 1;
		int state = READING;

		public Handler(Selector sel, SocketChannel c) throws IOException {
			socket = c;
			c.configureBlocking(false);
			sk = socket.register(sel, 0);
			sk.attach(this);
			sk.interestOps(SelectionKey.OP_READ);
			sel.wakeup();
		}

		boolean inputIsComplete() {
			return false;
		}

		boolean outputIsComplete() {
			return false;
		}

		void process() {
		}

		@Override
		public void run() {
			try {
				socket.read(input);
				if (inputIsComplete()) {
					process();
					sk.attach(new Sender());
					sk.interestOps(SelectionKey.OP_WRITE);
					sk.selector().wakeup();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		class Sender implements Runnable {

			@Override
			public void run() {
				try {
					socket.write(output);
					if (outputIsComplete()) {
						sk.cancel();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		private void Sender() throws IOException {
			socket.read(input);
			if (inputIsComplete()) {
				process();
				state = SENDING;
				sk.interestOps(SelectionKey.OP_WRITE);
			}
		}

		private void read() throws IOException {
			socket.write(output);
			if (outputIsComplete()) {
				sk.cancel();
			}
		}

	}
}
