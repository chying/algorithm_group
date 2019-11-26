package algorithm.chapter3.second.dfsbfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ��515. ��ÿ�������������ֵ������Ҫ�ڶ�������ÿһ�����ҵ�����ֵ�� ʾ���� ����:
 * 
 * 1 / \ 3 2 / \ \ 5 3 9
 * 
 * ���: [1, 3, 9] ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 * @author chying
 *
 */
public class LeetCode_515_519 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (null != root) {
			Deque<TreeNode> queue = new ArrayDeque<>();
			queue.addLast(root);
			while (queue.size() > 0) {
				int size = queue.size();
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.pollFirst();
					int curVal = node.val;
					if (max < curVal) {
						max = curVal;
					}
					if (node.left != null) {
						queue.addLast(node.left);
					}
					if (node.right != null) {
						queue.addLast(node.right);
					}
				}
				result.add(max);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode_515_519 a = new LeetCode_515_519();
		TreeNode root_1 = new LeetCode_515_519().new TreeNode(1);
		TreeNode root_3 = new LeetCode_515_519().new TreeNode(3);
		TreeNode root_2 = new LeetCode_515_519().new TreeNode(2);
		TreeNode root_5 = new LeetCode_515_519().new TreeNode(5);
		TreeNode root_31 = new LeetCode_515_519().new TreeNode(3);
		TreeNode root_9 = new LeetCode_515_519().new TreeNode(9);
		root_1.left = root_3;
		root_1.right = root_2;
		root_3.left = root_5;
		root_3.right = root_31;
		root_2.right = root_9;
		System.out.println(a.largestValues(root_1));
	}

	public List<Integer> largestValues1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res, 0);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res, int d) {
		if (root == null) {
			return;
		}
		// expand list size
		if (d == res.size()) {
			res.add(root.val);
		} else {
			// or set value
			res.set(d, Math.max(res.get(d), root.val));
		}
		helper(root.left, res, d + 1);
		helper(root.right, res, d + 1);
	}
}
