package algorithm.exercise.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【】
 * 
 * @author chying
 *
 */
public class CanReach {

	public boolean canReach(int[] arr, int start) {
		if (null != arr && arr.length > 0 && start < arr.length && start >= 0) {
			// 0的下标 置为1，未访问过 0，访问过 -1
			int[] visited = new int[arr.length];
			boolean hasZero = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					visited[i] = 1;
					if (!hasZero) {
						hasZero = true;
					}
				}
			}

			if (!hasZero) {
				return false;
			}

			Deque<Integer> deque = new ArrayDeque<>();
			deque.add(start);
			while (!deque.isEmpty()) {
				int size = deque.size();
				for (int i = 0; i < size; i++) {
					int index = deque.poll();
					int num1 = index + arr[index];
					int num2 = index - arr[index];
					if (num1 >= 0 && num1 < arr.length && visited[num1] != -1) {
						if (visited[num1] == 1) {
							return true;
						} else {
							deque.add(num1);
							visited[num1] = -1;
						}
					}
					if (num2 >= 0 && num2 < arr.length && visited[num2] != -1) {
						if (visited[num2] == 1) {
							return true;
						} else {
							deque.add(num2);
							visited[num2] = -1;
						}
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CanReach a = new CanReach();
		int[] arr = new int[] { 3,0,2,1,2 };
		int start = 2;
		System.out.println(a.canReach(arr, start));
	}
}
