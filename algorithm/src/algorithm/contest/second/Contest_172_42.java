package algorithm.contest.second;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 【5318. 灌溉花园的最少水龙头数目】
 * https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * 
 * @author chying
 *
 */
public class Contest_172_42 {

	public static void main(String[] args) {
		Contest_172_42 a = new Contest_172_42();
		int[] ranges = new int[] { 0, 0, 0, 0 };
		System.out.println(a.minTaps(3, ranges));
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
		int res = 0;
		int pre = 0;
		int cur = 0;
		int index = 0;
		while (index < ranges.length) {
			res++;
			for (; index < ranges.length; index++) {
				if (interval[index][0] <= pre) {
					cur = Math.max(cur, interval[index][1]);
					if (cur >= n) {
						return res;
					}
				} else {
					break;
				}
			}
			if (cur == 0) {
				return -1;
			}
			pre = cur;
		}
		return res;

	}

}
