package algorithm.chapter2.template;

import java.util.List;

import algorithm.chapter2.second.LeetCode_47_519_N;

/**
 * ��47. ȫ����ii������һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С� ʾ��: ����: [1,1,2] ���: [ [1,1,2],
 * [1,2,1], [2,1,1] ] ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutations-ii
 * 
 * @author chying
 *
 */
public class LeetCode_47_519 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		return null;
	}

	public static void main(String[] args) {
		LeetCode_47_519_N a = new LeetCode_47_519_N();
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> result = a.permuteUnique(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
