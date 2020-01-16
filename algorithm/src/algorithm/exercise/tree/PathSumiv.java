package algorithm.exercise.tree;

/**
 * ¡¾666. Â·¾¶ºÍ IV¡¿ https://leetcode-cn.com/problems/path-sum-iv/
 * 
 * @author chying
 *
 */
public class PathSumiv {

	public int pathSum(int[] nums) {
		if (null != nums) {
			int[] arr = new int[16];
			int level = 1;
			int pos = 1;
			int j = 0;
			int carry = 1;
			for (int i = 0; i < nums.length; i++) {
				int temp = nums[i];
				if (temp / 100 > level) {
					carry *= 2;
				}
				level = temp / 100;
				pos = temp % 100 / 10;
				j = (level - 1) * carry + pos-1;
				arr[j] = temp % 10;

			}
		}
		return 0;
	}

	public static void main(String[] args) {
		PathSumiv a = new PathSumiv();
		int[] nums = new int[] { 113, 215, 221 };
		System.out.println(a.pathSum(nums));
	}
}
