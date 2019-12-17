package algorithm.chapter2.exe.recursion;

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
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (null != nums && nums.length > 0) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> sublist = new ArrayList<>();
			backtrace(result, sublist, nums);
			return result;
		}
		return null;
	}

	private void backtrace(List<List<Integer>> result, List<Integer> sublist, int[] nums) {
		if (sublist.size() == nums.length) {
			result.add(new ArrayList<Integer>(sublist));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (sublist.contains(nums[i])) {
				continue;
			}
			sublist.add(nums[i]);
			backtrace(result, sublist, nums);
			sublist.remove(sublist.size() - 1);
		}

	}

	public static void main(String[] args) {
		Permutations a = new Permutations();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = a.permute(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
