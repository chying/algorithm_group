package algorithm.exercise.linklist;

/**
 * 【19. 删除链表的倒数第N个节点】
 * 
 * @author chying
 *
 */
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode p = dummyNode;
		ListNode fast = dummyNode;
		int i = 0;
		while (i < n + 1 && fast != null) {
			fast = fast.next;
			i++;
		}
		while (fast != null) {
			p = p.next;
			fast = fast.next;
		}
		p.next = p.next.next;
		return dummyNode.next;
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList a = new RemoveNthNodeFromEndOfList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(ListNode.printStr(a.removeNthFromEnd(head, 2)));
	}

	public ListNode removeNthFromEnd_1(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes
		// apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}

}
