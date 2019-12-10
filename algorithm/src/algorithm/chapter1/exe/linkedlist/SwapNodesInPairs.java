package algorithm.chapter1.exe.linkedlist;

/**
 * 【24. 两两交换链表中的节点】给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例: 给定 1->2->3->4, 你应该返回 2->1->4->3. 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class SwapNodesInPairs {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode p = head;
		head = head.next;
		while (p != null && p.next != null) {
			ListNode q = p.next;
			ListNode tempNode = q.next;
			q.next = p;
			p.next = tempNode;

			p = tempNode;
		}
		return head;
	}

	public static void main(String[] args) {
		SwapNodesInPairs a = new SwapNodesInPairs();
		ListNode node1 = new SwapNodesInPairs().new ListNode(1);
		ListNode node2 = new SwapNodesInPairs().new ListNode(2);
		ListNode node3 = new SwapNodesInPairs().new ListNode(3);
		ListNode node4 = new SwapNodesInPairs().new ListNode(4);
		ListNode node5 = new SwapNodesInPairs().new ListNode(5);
		ListNode node6 = new SwapNodesInPairs().new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode node = a.swapPairs(node1);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

}
