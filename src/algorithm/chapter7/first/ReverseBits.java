package algorithm.chapter7.first;

/**
 * 【190. 颠倒二进制位】颠倒给定的 32 位无符号整数的二进制位。 示例 1： 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000 解释: 输入的二进制串
 * 00000010100101000001111010011100 表示无符号整数 43261596， 因此返回 964176192，其二进制表示形式为
 * 00111001011110000010100101000000。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n >>>= 1; // CATCH: must do unsigned shift
			if (i < 31) // CATCH: for last digit, don't shift!
				result <<= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		ReverseBits a = new ReverseBits();
	}

	public int reverseBits1(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int end = n & 1;
			n >>= 1;
			result <<= 1;
			result |= end;
		}
		return result;
	}

}
