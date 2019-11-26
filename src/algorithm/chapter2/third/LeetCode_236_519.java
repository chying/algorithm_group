package algorithm.chapter2.third;

/**
 * 【236. 二叉树的最近公共祖先】给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点
 * p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 例如，给定如下二叉树: 
 * root = [3,5,1,6,2,0,8,null,null,7,4] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 
 * @author chying
 *
 */
public class LeetCode_236_519 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return ifInNodeChildren(root, p, q);
	}

	private TreeNode ifInNodeChildren(TreeNode node, TreeNode p, TreeNode q) {
		if (node != null) {
			if (node.val == p.val || node.val == q.val) {
				return node;
			} else {
				TreeNode leftNode = ifInNodeChildren(node.left, p, q);
				TreeNode rightNode = ifInNodeChildren(node.right, p, q);
				if (leftNode == null && rightNode == null) {
					return null;
				}else {
//					if() {
//						
//					}
				}
			}
		}
		return null;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		LeetCode_236_519 a = new LeetCode_236_519();
		TreeNode node3 = new LeetCode_236_519().new TreeNode(3);
		TreeNode node5 = new LeetCode_236_519().new TreeNode(5);
		TreeNode node1 = new LeetCode_236_519().new TreeNode(1);
		TreeNode node6 = new LeetCode_236_519().new TreeNode(6);
		TreeNode node2 = new LeetCode_236_519().new TreeNode(2);
		TreeNode node0 = new LeetCode_236_519().new TreeNode(0);
		TreeNode node8 = new LeetCode_236_519().new TreeNode(8);
		TreeNode node7 = new LeetCode_236_519().new TreeNode(7);
		TreeNode node4 = new LeetCode_236_519().new TreeNode(4);
		node3.left = node5;
		node3.right = node1;
		node5.left = node6;
		node5.right = node2;
		node2.left = node7;
		node2.right = node4;
		node1.left = node0;
		node1.right = node8;
		a.lowestCommonAncestor(node3, node5, node1);
	}
}
