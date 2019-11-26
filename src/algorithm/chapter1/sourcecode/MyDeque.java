package algorithm.chapter1.sourcecode;

public class MyDeque {
	public static void main(String[] args) {
//		Deque<Integer> deque = new ArrayDeque<>();
//		deque.addFirst(1);
//		deque.addFirst(2);
//		deque.addFirst(3);
//		deque.addFirst(4);
//		System.out.println(deque);
//		
//		int peekNum=deque.peek();
//		int peekFirstNum=deque.peekFirst();
//		int peekLastNum=deque.peekLast();
//		System.out.println("peekNum:"+peekNum+",peekFirstNum:"+peekFirstNum+",peekLastNum="+peekLastNum);
//		
//		while(deque.size()>0) {
//			System.out.println(deque.pop());
//		}
//		
//		System.out.println(deque);
		
		int[] array=new int[16];
		int head=0;
		 head = (head - 1) & (array.length - 1);
		 
		 ArrayDeque<String> a=new ArrayDeque<String>();
		 a.addFirst("1");
		 a.addFirst("2");
//		 a.addFirst("3");
//		 a.addFirst("4");
//		 a.addFirst("5");
//		 a.addFirst("6");
//		 a.addFirst("7");
//		 a.addFirst("8");
		 a.addLast("8");
		 
		 a.addFirst("9");
		 a.addFirst("10");
		 a.addFirst("11");
		 a.addFirst("12");
		 a.addFirst("13");
		 a.addFirst("14");
		 a.addFirst("15");
		 a.addFirst("16");
		 a.addFirst("17");
		 a.addFirst("18");
		 a.addFirst("19");
		 
		System.out.println(array.length);
	}
}
