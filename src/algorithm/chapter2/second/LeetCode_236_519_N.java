package algorithm.chapter2.second;

/**
 * 【236. 二叉树的最近公共祖先】给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点
 * p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 例如，给定如下二叉树: 
 * root = [3,5,1,6,2,0,8,null,null,7,4] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 
 * @author chying
 *
 */
public class LeetCode_236_519_N {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
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
		LeetCode_236_519_N a = new LeetCode_236_519_N();
		TreeNode node_3 = new LeetCode_236_519_N().new TreeNode(3);
		TreeNode node_5 = new LeetCode_236_519_N().new TreeNode(5);
		TreeNode node_1 = new LeetCode_236_519_N().new TreeNode(1);
		TreeNode node_6 = new LeetCode_236_519_N().new TreeNode(6);
		TreeNode node_2 = new LeetCode_236_519_N().new TreeNode(2);
		TreeNode node_0 = new LeetCode_236_519_N().new TreeNode(0);
		TreeNode node_8 = new LeetCode_236_519_N().new TreeNode(8);
		TreeNode node_7 = new LeetCode_236_519_N().new TreeNode(7);
		TreeNode node_4 = new LeetCode_236_519_N().new TreeNode(4);
		node_3.left = node_5;
		node_3.right = node_1;
		node_5.left = node_6;
		node_5.right = node_2;
		node_2.left = node_7;
		node_2.right = node_4;
		node_1.left = node_0;
		node_1.right = node_8;

		
		a.lowestCommonAncestor(node_3, node_5, node_4);
//		List<List<Integer>> result = a.levelOrder(root);
//		for (List<Integer> list : result) {
//			System.out.println(list.toString());
//		}
	}
}
