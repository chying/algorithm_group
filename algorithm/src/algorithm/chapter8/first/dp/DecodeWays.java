package algorithm.chapter8.first.dp;

/**
 * 【91. 解码方法】一条包含字母 A-Z 的消息�?�过以下方式进行了编码： 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 给定�?个只包含数字的非空字符串，请计算解码方法的�?�数�? 来源：力扣（LeetCode�?
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??
 * 
 * @author chying
 *
 */
public class DecodeWays {
	/**
	 * 像爬楼梯啊
	 * 
	 * @param s1
	 * @return
	 */
	public int numDecodings(String s) {
		if (s.charAt('0') == s.length()) {
			return 0;
		}
		int len = s.length();
		char[] arr = s.toCharArray();
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < len + 1; i++) {
			int index = i - 1;
			if (arr[index] == '0') {
				if (arr[index - 1] == '1' || arr[index - 1] == '2') {
					dp[i] = dp[i - 2];// 一次只能上两步
				}
			} else {
				if (arr[index - 1] == '1' || (arr[index - 1] == '2' && arr[index] >= '1' && arr[index] <= '6')) {
					dp[i] = dp[i - 1] + dp[i - 2];
				} else {
					dp[i] = dp[i - 1];
				}
			}
		}
		return dp[len];
	}

	public static void main(String[] args) {
		DecodeWays a = new DecodeWays();
		System.out.println(a.numDecodings("1012"));
	}

	public int numDecodings1(String s1) {
		char[] s = s1.toCharArray();
		if (s[0] == '0')
			return 0;
		int pre = 1, curr = 1; // dp[-1] = dp[0] = 1
		for (int i = 1; i < s.length; i++) {
			int tmp = curr;
			if (s[i] == '0')
				if (s[i - 1] == '1' || s[i - 1] == '2')
					curr = pre;
				else
					return 0;
			else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6'))
				curr = curr + pre;
			pre = tmp;
		}
		return curr;
	}

	int numDecodings11(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 2; i <= n; i++) {
			int first = Integer.valueOf(s.substring(i - 1, i));
			int second = Integer.valueOf(s.substring(i - 2, i));
			if (first >= 1 && first <= 9) {
				dp[i] += dp[i - 1];
			}
			if (second >= 10 && second <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[n];
	}

}
