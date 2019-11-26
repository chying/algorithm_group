package algorithm.chapter1.sourcecode;

import java.util.Arrays;

public class MyPriority {

	public static void main(String[] args) {
		PriorityQueue<Integer> a = new PriorityQueue<>();
		a.add(8);
		a.add(8);
		a.add(5);
		a.add(6);
		
		System.out.println(Arrays.toString(a.toArray()));
	}
}
