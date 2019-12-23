package algorithm.exercise.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ¡¾412. Fizz Buzz¡¿https://leetcode-cn.com/problems/fizz-buzz/
 * 
 * @author chying
 *
 */
public class FizzBuzz {

	public List<String> fizzBuzz(int n) {
		String[] arr = new String[n];

		for (int i = 1; i <= n; i++)
			arr[i - 1] = String.valueOf(i);

		for (int i = 3; i <= n; i += 3)
			arr[i - 1] = "Fizz";

		for (int i = 5; i <= n; i += 5)
			arr[i - 1] = "Buzz";

		for (int i = 15; i <= n; i += 15)
			arr[i - 1] = "FizzBuzz";

		return new ArrayList<>(Arrays.asList(arr));
	}

	public static void main(String[] args) {
		FizzBuzz a = new FizzBuzz();

		System.out.println(a.fizzBuzz(15));
	}
}
