package algorithm.exercise.string;

/**
 * °æ266. ªÿŒƒ≈≈¡–°ø https://leetcode-cn.com/problems/palindrome-permutation/
 * 
 * @author chying
 *
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (null != s) {
			if (s.length() == 1) {
				return true;
			}
			boolean[] arr = new boolean[256];
			for (char ch : s.toCharArray()) {
				if (!arr[ch]) {
					arr[ch] = !arr[ch];
				} else {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePermutation a = new PalindromePermutation();
		String s = "a";
		System.out.println(a.canPermutePalindrome(s));
	}
}
