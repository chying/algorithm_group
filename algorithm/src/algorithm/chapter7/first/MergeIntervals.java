package algorithm.chapter7.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

		// Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// a[0] - b[0]大于0就交换顺序
		// 根据二维数组第一个数字大小按每一行整体排序
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int i = 0;
		while (i < intervals.length) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			// i不能到最后一行,所以要小于(数组的长度 - 1)
			// 判断所在行的right和下一行的left大小,对right重新进行赋最大值,之后再不断进行while循环判断
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
		int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		a.merge(intervals);
		for (int[] num : intervals) {
			System.out.println(Arrays.toString(num));
		}
	}
}
