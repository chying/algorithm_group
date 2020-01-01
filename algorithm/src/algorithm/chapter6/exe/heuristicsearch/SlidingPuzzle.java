package algorithm.chapter6.exe.heuristicsearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 【773. 滑动谜题】在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 示例： 输入：board =
 * [[1,2,3],[4,0,5]] 输出：1 解释：交换 0 和 5 ，1 步完成
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class SlidingPuzzle {
	static private Map<Integer, List<Integer>> map = new HashMap<>();
	{
		map.put(0, new ArrayList<>(Arrays.asList(1, 3)));
		map.put(1, new ArrayList<>(Arrays.asList(0, 2, 4)));
		map.put(2, new ArrayList<>(Arrays.asList(1, 5)));
		map.put(3, new ArrayList<>(Arrays.asList(0, 4)));
		map.put(4, new ArrayList<>(Arrays.asList(1, 3, 5)));
		map.put(5, new ArrayList<>(Arrays.asList(2, 4)));
	}

	public int slidingPuzzle(int[][] board) {
		if (board != null && board.length > 0) {
			int m = board.length;
			int n = board[0].length;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(board[i][j]);
				}
			}
			String targerStr = "123450";
			String newSB = sb.toString();
			if (newSB.equals(targerStr)) {
				return 0;
			}
			Set<String> set = new HashSet<>();
			Deque<String> queue = new ArrayDeque<>();
			set.add(newSB);
			queue.add(newSB);
			int result = 0;
			int zeroIndex = -1;
			while (!queue.isEmpty()) {
				int size = queue.size();
				result++;
				for (int i = 0; i < size; i++) {
					String s = queue.poll();
					zeroIndex = s.indexOf('0');
					List<Integer> list = map.get(zeroIndex);
					for (int index : list) {
						String old = s;
						char[] arr = s.toCharArray();
						arr[zeroIndex] = arr[index];
						arr[index] = '0';
						String newVal = String.valueOf(arr);
						if (newVal.equals(targerStr)) {
							return result;
						}
						if (!set.contains(newVal)) {
							set.add(newVal);
							queue.add(newVal);
						}
						s = old;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		SlidingPuzzle a = new SlidingPuzzle();
		int[][] board = new int[][] { { 1, 2, 3 }, { 4, 5, 0 } };
//[[1,2,3],[4,5,0]]
		System.out.println(a.slidingPuzzle(board));

	}

}
