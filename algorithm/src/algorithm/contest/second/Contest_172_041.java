package algorithm.contest.second;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 【5318. 灌溉花园的最少水龙头数目】
 * https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * 
 * @author chying
 *
 */
public class Contest_172_041 {

	public static void main(String[] args) {
		Contest_172_041 a = new Contest_172_041();
		int[] ranges = new int[] { 3, 4, 1, 1, 0, 0 };
		System.out.println(a.minTaps(5, ranges));
	}

	public int minTaps(int n, int[] ranges) {
		int[][] intervals = new int[n + 1][2];
		for (int i = 0; i <= n; i++) {
			intervals[i][0] = i - ranges[i];
			intervals[i][1] = i + ranges[i];
		}

		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});

		int end = 0;
		int index = 0;
		Queue<int[]> q = new LinkedList<>();

		while (index <= n && intervals[index][0] <= 0) {
			q.offer(intervals[index++]);
		}
		int res = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				end = Math.max(end, cur[1]);
				if (end >= n) {
					return res;
				}
			}
			while (index <= n && intervals[index][0] <= end) {
				q.offer(intervals[index++]);
			}
			res++;
		}
		if (end < n) {
			return -1;
		}
		return res;
	}
	
	
}
