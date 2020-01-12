package algorithm.contest;

/**
 * 【】
 * 
 * @author chying
 *
 */
public class Contest_171_04 {
	public int minimumDistance(String word) {
		int[][] index = new int[word.length()][2];
		for (int i = 0; i < word.length(); i++) {
			int num = word.charAt(i) - 65;
			index[i][0] = num / 6;
			index[i][1] = num % 6;
		}
		int[][] dp = new int[word.length()][2];
		// 0 使用第一根手指 1 使用第二根手指
		dp[0][0] = 0;
		dp[0][1] = 0;

		for (int i = 1; i < word.length(); i++) {
			dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		return -1;
	}

	public static void main(String[] args) {
		Contest_171_04 a = new Contest_171_04();
		String word = "CAKE";
		System.out.println(a.minimumDistance(word));
	}
}
