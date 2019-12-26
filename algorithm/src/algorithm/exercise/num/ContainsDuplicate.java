package algorithm.exercise.num;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		int sum = 0;
		int old = 0;
		if (null != nums && nums.length > 0) {
			if (nums.length == 1) {
				return false;
			}
			for (int num : nums) {
				old = sum;
				sum ^= num;
				if (old - sum == num) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate a = new ContainsDuplicate();
	}
}
