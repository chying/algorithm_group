package algorithm.exercise.arr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * ��219. �����ظ�Ԫ�� II��https://leetcode-cn.com/problems/contains-duplicate-ii/
 * 
 * @author chying
 *
 */
public class Containsduplicateii {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (null != nums) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int key = nums[i];
				if (map.containsKey(key)) {
					if (Math.abs(map.get(key) - i) <= k) {
						return true;
					}
				}
				map.put(key, i);
			}
		}
		return false;
	}

	public boolean containsNearbyDuplicate_TreeSet(int[] nums, int k) {
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; ++i) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Containsduplicateii a = new Containsduplicateii();
		int[] nums = new int[] { 99, 99 };
		int k = 2;
		System.out.println(a.containsNearbyDuplicate_3(nums, k));
	}

	public boolean containsNearbyDuplicate_3(int[] nums, int k) {
		Set<Integer> set = new HashSet<>(nums.length);
		// ��ֹ K > nums.length Խ��
		k = k > nums.length ? nums.length : k;
		// ���� k ֮ǰ��
		for (int i = 0; i < k; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
		}
		// ���� K ֮���
		for (int i = k; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
			set.remove(nums[i - k]);
		}

		return false;
	}

}
