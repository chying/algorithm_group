package algorithm.exercise.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * °æ739. √ø»’Œ¬∂»°ø https://leetcode-cn.com/problems/daily-temperatures/
 * 
 * @author chying
 *
 */
public class DailyTemperatures {

	public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		if (null != T) {
			for (int i = 0; i < T.length; i++) {
				for (int j = i + 1; j < T.length; j++) {
					if (T[j] > T[i]) {
						result[i] = j - i;
						break;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		DailyTemperatures a = new DailyTemperatures();
		int[] t = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
		System.out.println(Arrays.toString(a.dailyTemperatures_ArrStack(t)));
	}

	public int[] dailyTemperatures_Stack(int[] T) {
		int[] result = new int[T.length];
		if (null != T) {
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < T.length; i++) {
				while (!deque.isEmpty() && T[i] > T[deque.peekFirst()]) {
					result[deque.peekFirst()] = i - deque.peekFirst();
					deque.pollFirst();
				}
				deque.push(i);
			}
		}
		return result;
	}

	public int[] dailyTemperatures_ArrStack(int[] T) {
		int[] result = new int[T.length];
		if (null != T) {
			int[] stack = new int[T.length];
			int top = -1;
			for (int i = 0; i < T.length; i++) {
				while (top >= 0 && T[i] > T[stack[top]]) {
					result[stack[top]] = i - stack[top];
					stack[top--] = 0;

				}
				stack[++top] = i;
			}
		}
		return result;
	}
}
