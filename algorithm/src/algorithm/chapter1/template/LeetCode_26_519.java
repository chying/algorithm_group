package algorithm.chapter1.template;

/**
 * ��ɾ�����������е��ظ������һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ� ���� nums =
 * [0,0,1,1,1,2,2,3,3,4], ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author chying
 *
 */
public class LeetCode_26_519 {
	public int removeDuplicates(int[] nums) {
		int i = 0;
		if (null != nums && nums.length > 0) {
			for (int j = 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					continue;
				}
				if (nums[i + 1] != nums[j]) {
					nums[i + 1] = nums[j];
				}
				i++;
			}
		}
		return i+1;
	}

	public static void main(String[] args) {
		LeetCode_26_519 a = new LeetCode_26_519();
//		int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int[] nums = new int[] { 0, 2,4 };
		int result = a.removeDuplicates(nums);
		System.out.println(result);
	}
}
