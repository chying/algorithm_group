package algorithm.exercise;

public class ClimbStair {
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int first = 1;
		int second = 2;
		int third = 3;
		for (int i = 3; i <= n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}

	public static void main(String[] args) {
		ClimbStair a = new ClimbStair();
		System.out.println(a.climbStairs(3));
		System.out.println(a.climbStairs(4));
		System.out.println(a.climbStairs(5));
	}
}
