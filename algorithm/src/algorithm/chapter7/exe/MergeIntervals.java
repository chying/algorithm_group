package algorithm.chapter7.exe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【56. 合并区间】给出一个区间的集合，请合并所有重叠的区间。 示例 1: 输入: [[1,3],[2,6],[8,10],[15,18]] 输出:
 * [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]. 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();
		if (intervals == null || intervals.length == 0)
			return res.toArray(new int[0][]);
		Arrays.sort(intervals, (n1, n2) -> n1[0] - n2[0]);
		int i = 0;
		while (i < intervals.length) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
				i++;
				right = Math.max(right, intervals[i][1]);
			}
			res.add(new int[] { left, right });
			i++;
		}

		return res.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		MergeIntervals a = new MergeIntervals();
		int[][] intervals = new int[][] { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
		int[][] res=	a.merge(intervals);
		for (int[] num : res) {
			System.out.println(Arrays.toString(num));
		}
	}
}
