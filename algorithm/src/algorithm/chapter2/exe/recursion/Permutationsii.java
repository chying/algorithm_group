package algorithm.chapter2.exe.recursion;

import java.util.List;

/**
 * ��47. ȫ����ii������һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С� ʾ��: ����: [1,1,2] ���: [ [1,1,2],
 * [1,2,1], [2,1,1] ] ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutations-ii
 * 
 * @author chying
 *
 */
public class Permutationsii {
	public List<List<Integer>> permuteUnique(int[] nums) {
		return null;
	}

	public static void main(String[] args) {
		Permutationsii a = new Permutationsii();
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> result = a.permuteUnique(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
