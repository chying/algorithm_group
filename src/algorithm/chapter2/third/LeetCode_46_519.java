package algorithm.chapter2.third;

import java.util.ArrayList;
import java.util.List;

/**
 * ��46. ȫ���С�����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С� ʾ��: ����: [1,2,3] ���: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ] ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutations
 * 
 * @author chying
 *
 */
public class LeetCode_46_519 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		permute(result, sublist, nums);
		return result;
	}

	private void permute(List<List<Integer>> result, List<Integer> sublist, int[] nums) {
		if (sublist.size() == nums.length) {
			result.add(new ArrayList<>(sublist));
			return;
		}
		for (int j = 0; j < nums.length; j++) {
			if (sublist.contains(nums[j])) {
				continue;
			} else {
				sublist.add(nums[j]);
				permute(result, sublist, nums);
				sublist.remove(sublist.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		LeetCode_46_519 a = new LeetCode_46_519();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = a.permute(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
