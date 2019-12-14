package algorithm.exercise;

public class SubtractSumInteger {
	public int subtractProductAndSum(int n) {
		int mutiply = 1;
		int sum = 0;
		while (n != 0) {
			int num = n % 10;
			mutiply *= num;
			sum += num;
			n = n / 10;
		}
		return mutiply - sum;
	}

	public static void main(String[] args) {
		SubtractSumInteger a = new SubtractSumInteger();
		System.out.println(a.subtractProductAndSum(234));
	}
}
