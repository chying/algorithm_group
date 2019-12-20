package algorithm.chapter3.exe.binsearch;

/**
 * 【153. 寻找旋转排序数组中的最小值】假设按照升序排序的数组在预先未知的某个点上进行了旋转。 ( 例如，数组 [0,1,2,4,5,6,7]
 * 可能变为 [4,5,6,7,0,1,2] )。 请找出其中最小的元素。 你可以假设数组中不存在重复元素。 示例 1: 输入: [3,4,5,1,2]
 * 输出: 1 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class FindMinimumInRotatedSortedArray {
	/**
	 * 发生旋转的区域 是最小值
	 * 
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
		if (null != nums && nums.length > 0) {
			int lo = 0;
			int hi = nums.length - 1;
			while (hi - lo > 1) {
				int mid = (lo + hi) / 2;
				if (nums[lo] >= nums[mid]) {
					hi = mid;
				} else if (nums[mid] >= nums[hi]) {
					lo = mid;
				} else {
					return nums[0];
				}
			}
			if (hi - lo == 1) {
				return nums[hi] > nums[lo] ? nums[lo] : nums[hi];
			} else {
				return nums[lo];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray a = new FindMinimumInRotatedSortedArray();
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(a.findMin(nums));
	}
}
