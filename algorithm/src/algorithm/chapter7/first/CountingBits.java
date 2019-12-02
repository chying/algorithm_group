package algorithm.chapter7.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【338. 比特位计数】给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1
 * 的数目并将它们作为数组返回。 示例 1: 输入: 2 输出: [0,1,1]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class CountingBits {
	public int[] countBits(int num) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= num; i++) {
			list.add(countBit(i));
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	private int countBit(int i) {
		int result = 0;
		while (i > 0) {
			i &= i - 1;
			result++;
		}
		return result;
	}

	public static void main(String[] args) {
		CountingBits a = new CountingBits();
		System.out.println(Arrays.toString(a.countBits(2)));
	}

	public int[] countBits_DP(int num) {

		return null;
	}
}
