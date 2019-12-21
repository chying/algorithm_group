package algorithm.chapter5.exe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【120. 三角形最小路径和】给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 例如，给定三角形：
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ] 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (null != triangle && triangle.size() > 0) {
			int m = triangle.size();
			int n = triangle.get(m - 1).size();
			int[] dp = new int[n];
			for (int i = 0; i < n; i++) {
				dp[i] = triangle.get(m - 1).get(i);
			}

			for (int i = m - 2; i >= 0; i--) {
				for (int j = 0; j <= i; j++) {
					dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
				}
			}

			return dp[0];
		}
		return 0;
	}

	public static void main(String[] args) {
		Triangle a = new Triangle();
		int[][] arr = new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> list = new ArrayList<>(Arrays.asList(arr[0][0]));
		List<Integer> list1 = new ArrayList<>(Arrays.asList(arr[1][0], arr[1][1]));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(arr[2][0], arr[2][1], arr[2][2]));
		List<Integer> list3 = new ArrayList<>(Arrays.asList(arr[3][0], arr[3][1], arr[3][2], arr[3][3]));
		triangle.add(list);
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);

		System.out.println(a.minimumTotal(triangle));

	}

}
