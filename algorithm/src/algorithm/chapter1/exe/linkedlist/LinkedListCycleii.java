package algorithm.chapter1.exe.linkedlist;

import java.util.HashSet;

import algorithm.chapter1.exe.linkedlist.LinkedListCycle.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 为了表示给定链表中的环，我们使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 说明：不允许修改给定的链表。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LinkedListCycleii {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if (null != head) {
			ListNode p = head;
			HashSet<ListNode> set = new HashSet<>();
			while (p != null) {
				if (!set.add(p)) {
					return p;
				}
				p = p.next;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		LinkedListCycleii a = new LinkedListCycleii();
		ListNode node3 = new LinkedListCycleii().new ListNode(3);
		ListNode node2 = new LinkedListCycleii().new ListNode(2);
		ListNode node0 = new LinkedListCycleii().new ListNode(0);
		ListNode node4 = new LinkedListCycleii().new ListNode(-4);
		node3.next = node2;
		node2.next = node0;
		node0.next = node4;
		node4.next = node2;
		System.out.println(a.detectCycle(node3));
	}
}
