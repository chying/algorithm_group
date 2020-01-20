package algorithm.exercise.greecy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * 【5318. 灌溉花园的最少水龙头数目】
 * https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * 
 * @author chying
 *
 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {

	public static void main(String[] args) {
		MinimumNumberOfTapsToOpenToWaterAGarden a = new MinimumNumberOfTapsToOpenToWaterAGarden();
		int[] ranges = new int[] { 1, 2, 1, 0, 2, 1, 0, 1 };
		/**
		 * 7 [1,2,1,0,2,1,0,1]
		 */
		System.out.println(a.minTaps(7, ranges));
	}

	public int minTaps(int n, int[] ranges) {
		int[][] interval = new int[ranges.length][2];
		for (int i = 0; i < ranges.length; i++) {
			interval[i][0] = i - ranges[i];
			interval[i][1] = i + ranges[i];
		}
		Arrays.sort(interval, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int index = 0;
		for (; index < ranges.length; index++) {
			if (interval[index][0] <= 0) {
				deque.add(interval[index][1]);
			} else {
				break;
			}
		}
		int res = 0;
		int distance = 0;
		while (!deque.isEmpty()) {
			res++;
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				distance = Math.max(distance, deque.poll());
				if (distance >= n) {
					return res;
				}
			}
			for (; index < ranges.length; index++) {
				if (interval[index][0] <= distance) {
					deque.add(interval[index][1]);
				} else {
					break;
				}
			}
		}
		return -1;
	}

}
