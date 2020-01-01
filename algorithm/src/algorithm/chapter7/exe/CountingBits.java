package algorithm.chapter7.exe;

import java.util.Arrays;

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
	public int[] countBits_DP(int num) {
		int[] result = new int[num + 1];
		int i = 1;
		int d = 0;
		while (i <= num) {
			while (d < i && i + d <= num) {
				result[i + d] = result[d] + 1;
				d++;
			}
			d = 0;
			i <<= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		CountingBits a = new CountingBits();
		System.out.println(Arrays.toString(a.countBits(7)));
	}

	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; ++i)
			ans[i] = ans[i & (i - 1)] + 1;
		return ans;
	}
}
