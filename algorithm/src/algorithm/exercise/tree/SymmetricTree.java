package algorithm.exercise.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ��101. �Գƶ�������https://leetcode-cn.com/problems/symmetric-tree/
 * 
 * @author chying
 *
 */
public class SymmetricTree {
	/**
	 * ��α���
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root != null) {
			Deque<TreeNode> deque = new ArrayDeque<>();
			deque.add(root);
			deque.add(root);
			while (!deque.isEmpty()) {
				TreeNode nodeL = deque.poll();
				TreeNode nodeR = deque.poll();
				if (nodeL == null && nodeR == null) {
					continue;
				}
				if (nodeL == null || nodeR == null) {
					return false;
				}
				if (nodeL.val != nodeR.val)
					return false;
				deque.add(nodeL.left);
				deque.add(nodeR.right);
				deque.add(nodeL.right);
				deque.add(nodeR.left);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SymmetricTree a = new SymmetricTree();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left=node2;
		node2.right=node3;
		TreeNode node22 = new TreeNode(2);
		TreeNode node23 = new TreeNode(3);
		node1.right=node22;
		node22.right=node23;
		
		System.out.println(a.isSymmetric(node1));
	}
	
	public boolean isSymmetric_re(TreeNode root) {
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}

	
}