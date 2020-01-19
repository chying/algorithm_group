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
public class Contest_172_04 {

	public static void main(String[] args) {
		Contest_172_04 a = new Contest_172_04();
		int[] ranges = new int[] { 3, 4, 1, 1, 0, 0 };
		System.out.println(a.minTaps(5, ranges));
	}

	public int minTaps(int n, int[] ranges) {
		int[][] clips = new int[n + 1][2];
		for (int i = 0; i < n + 1; i++) {
			clips[i][0] = i - ranges[i];
			clips[i][1] = i + ranges[i];
		}
		return videoStitching(clips, n);
	}

	public int videoStitching(int[][] clips, int T) {
		int[] cover = new int[T];
		for (int i = 0; i < clips.length; i++) {
			int tmp = Math.max(0, clips[i][0]);
			if (tmp < T)
				cover[tmp] = Math.max(cover[tmp], clips[i][1]);
		}
		// System.out.println(Arrays.toString(cover));
		int ans = 1;
		int covered = cover[0];
		int touching = 0;
		for (int i = 0; i < T; i++) {
			// System.out.println(i + " " + covered + " " + touching);
			if (covered >= T || i > covered)
				break;
			touching = Math.max(touching, cover[i]);
			if (i >= covered) {
				ans++;
				covered = touching;
			}
		}
		return covered >= T ? ans : -1;
	}
}
