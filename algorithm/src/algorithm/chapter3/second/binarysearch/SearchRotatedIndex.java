package algorithm.chapter3.second.binarysearch;

public class SearchRotatedIndex {
	public int getRotatedIndex(int[] nums) {
		if (null != nums) {
			int left = 0;
			int right = nums.length - 1;
			int mid = 0;
			while (right - 1 > left) {
				mid = left + (right - left) / 2;
				if ((nums[mid] - nums[left]) * (nums[right] - nums[mid]) < 0) {
					if (nums[mid] - nums[left] < 0) {
						right = mid;
					} else {
						left = mid;
					}
				} else {
					return 0;
				}
			}
			return nums[left] < nums[right] ? left : right;
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchRotatedIndex a = new SearchRotatedIndex();
		int[] nums = new int[] { 4, 5, 6, 1, 2, 3 };
		System.out.println(a.getRotatedIndex(nums));
	}
}
