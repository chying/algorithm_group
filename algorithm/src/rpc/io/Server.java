package rpc.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	final static int PORT = 8080;
	final static int MAX_INPUT = 1000;

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(PORT);
			while (!Thread.interrupted()) {
				new Thread(new Handler(ss.accept())).start();
			}
		} catch (IOException ex) {
		}
	}

	static class Handler implements Runnable {
		final Socket socket;

		Handler(Socket s) {
			socket = s;
		}

		@Override
		public void run() {
			try {
				byte[] input = new byte[MAX_INPUT];
				socket.getInputStream().read(input);
				byte[] output = process(input);
				socket.getOutputStream().write(output);
			} catch (Exception e) {
			}
		}

		private byte[] process(byte[] cmd) {
			return null;
		}
	}
}
