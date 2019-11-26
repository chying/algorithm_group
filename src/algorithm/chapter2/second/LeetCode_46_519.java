package algorithm.chapter2.second;

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
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; 
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		LeetCode_46_519 a = new LeetCode_46_519();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result=a.permute(nums);
		for(List<Integer> list:result) {
			System.out.println(list.toString());
		}
	}
}
