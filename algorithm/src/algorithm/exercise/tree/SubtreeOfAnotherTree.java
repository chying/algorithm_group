package algorithm.exercise.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 【572. 另一个树的子树】 https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 
 * @author chying
 *
 */
public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		/**
		 * 先层次遍历 找到子树根节点
		 */
		if (s != null && t != null) {
			Deque<TreeNode> deque = new LinkedList<>();
			deque.add(s);
			while (!deque.isEmpty()) {
				TreeNode node = deque.poll();
				if (node.val == t.val) {
					if (isSame(node, t)) {
						return true;
					}
				}
				if (node.left != null) {
					deque.add(node.left);
				}
				if (node.right != null) {
					deque.add(node.right);
				}
			}
		}
		return false;

	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null || s.val != t.val) {
			return false;
		}
		return isSame(s.left, t.left) && isSame(s.right, t.right);

	}

	public boolean isSubtree1(TreeNode s, TreeNode t) {
		if(t==null) return true;
        if(s==null) return false;

        if(s.val!=t.val){
            return isSubtree(s.left,t) || isSubtree(s.right,t);
        }
        else{//s.val == t.val
            return isSame(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
        }

	}
	public static void main(String[] args) {
		SubtreeOfAnotherTree a = new SubtreeOfAnotherTree();
		TreeNode s = new TreeNode(1);
		s.left = new TreeNode(1);
//		s.right = new TreeNode(5);
//		s.left.left = new TreeNode(1);
//		s.left.right = new TreeNode(2);
		TreeNode t = new TreeNode(1);
//		t.left = new TreeNode(1);
//		t.right = new TreeNode(2);
		System.out.println(a.isSubtree1(s, t));
	}
}
