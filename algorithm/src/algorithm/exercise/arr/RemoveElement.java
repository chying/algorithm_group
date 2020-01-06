package algorithm.exercise.arr;

/**
 * ¡¾27. ÒÆ³ıÔªËØ¡¿ https://leetcode-cn.com/problems/remove-element/
 * 
 * @author chying
 *
 */
public class RemoveElement {
	/**
	 * ÒÆ¶¯0 ÀàËÆ
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				count++;
			} else {
				if (count > 0) {
					nums[i - count] = nums[i];
					nums[i] = val;
				}
			}
		}
		return nums.length - count;
	}

	public static void main(String[] args) {
		RemoveElement a = new RemoveElement();
		int[] nums = new int[] { 3, 2, 2, 3 };
		System.out.println(a.removeElement(nums, 3));
	}
}
