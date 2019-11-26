package algorithm.chapter1.template.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【25. K 个一组翻转链表】给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 示例 : 给定这个链表：1->2->3->4->5 当 k = 2 时，应当返回:
 * 2->1->4->3->5 当 k = 3 时，应当返回: 3->2->1->4->5 说明 : 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class ReverseNodesInkGroup {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode newHead = new ListNode(-1);
		ListNode cur = head;
		ListNode p = head;
		newHead.next = head;
		Deque<ListNode> deque = new ArrayDeque<>();
		while (p != null && k-- > 0) {
			deque.addFirst(cur);
			p = p.next;
		}
		if (cur != null) {
			while (deque.size() > 0) {
				cur.next = deque.pollFirst();
				cur = cur.next;
			}
		} else {
			cur = p;
		}
		return newHead.next;
	}

	public static void main(String[] args) {
		ReverseNodesInkGroup a = new ReverseNodesInkGroup();
		ListNode node1 = new ReverseNodesInkGroup().new ListNode(1);
		ListNode node2 = new ReverseNodesInkGroup().new ListNode(2);
		ListNode node3 = new ReverseNodesInkGroup().new ListNode(3);
		ListNode node4 = new ReverseNodesInkGroup().new ListNode(4);
		ListNode node5 = new ReverseNodesInkGroup().new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode node = a.reverseKGroup(node1, 3);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
