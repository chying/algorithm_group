package algorithm.chapter1.template.linkedlist;

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
		ListNode cur = new ListNode(-1);
		ListNode p = cur;
		ListNode firstNode = head;
		while (firstNode != null) {
			ListNode secondNode = firstNode.next;
			if (secondNode != null) {
				ListNode temp = secondNode.next;
				cur.next = secondNode;
				cur = cur.next;
				cur.next = firstNode;
				cur = cur.next;
				firstNode = temp;
			} else {
				cur.next = firstNode;
				firstNode = firstNode.next;
				cur = cur.next;
			}
		}
		cur.next = null;
		return p.next;

	}

	public static void main(String[] args) {
		SwapNodesInPairs a = new SwapNodesInPairs();
		ListNode node1 = new SwapNodesInPairs().new ListNode(1);
		ListNode node2 = new SwapNodesInPairs().new ListNode(2);
		ListNode node3 = new SwapNodesInPairs().new ListNode(3);
		ListNode node4 = new SwapNodesInPairs().new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode node = a.swapPairs(node1);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public ListNode swapPairs1(ListNode head) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode temp = pre;
		while (temp.next != null && temp.next.next != null) {
			ListNode start = temp.next;
			ListNode end = temp.next.next;
			temp.next = end;
			start.next = end.next;
			end.next = start;
			temp = start;
		}
		return pre.next;
	}
}
