package algorithm.chapter3.exe.bfsdfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 【515. 在每个树行中找最大值】您需要在二叉树的每一行中找到最大的值。 示例： 输入:
 * 
 * 1 / \ 3 2 / \ \ 5 3 9
 * 
 * 输出: [1, 3, 9] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class FindLargestValueInEachTreeRow {
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
			Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
			deque.add(root);
			while (!deque.isEmpty()) {
				int size = deque.size();
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.pollLast();
					int num = node.val;
					max = Math.max(num, max);
					if (node.left != null) {
						deque.addFirst(node.left);
					}
					if (node.right != null) {
						deque.addFirst(node.right);
					}
				}
				result.add(max);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FindLargestValueInEachTreeRow a = new FindLargestValueInEachTreeRow();
		TreeNode node1 = new FindLargestValueInEachTreeRow().new TreeNode(1);
		TreeNode node3 = new FindLargestValueInEachTreeRow().new TreeNode(3);
		TreeNode node2 = new FindLargestValueInEachTreeRow().new TreeNode(2);
		TreeNode node5 = new FindLargestValueInEachTreeRow().new TreeNode(5);
		TreeNode node3_1 = new FindLargestValueInEachTreeRow().new TreeNode(3);
		TreeNode node9 = new FindLargestValueInEachTreeRow().new TreeNode(9);

		node1.left = node3;
		node1.right = node2;

		node3.left = node5;
		node3.right = node3_1;

		node2.right = node9;

		System.out.println(a.largestValues(node1));

	}
}
