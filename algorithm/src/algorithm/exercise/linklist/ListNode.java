package algorithm.exercise.linklist;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	static ListNode getListNode() {
		ListNode p = new ListNode(1);
		p.next = new ListNode(2);
		p.next.next = new ListNode(3);
		p.next.next.next = new ListNode(4);
		p.next.next.next.next = new ListNode(5);
		return p;
	}

	static ListNode getListNode1() {
		ListNode p = new ListNode(2);
		p.next = new ListNode(4);
		p.next.next = new ListNode(3);
		return p;
	}

	static ListNode getListNode2() {
		ListNode p = new ListNode(5);
		p.next = new ListNode(6);
		p.next.next = new ListNode(4);
		return p;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

	static String printStr(ListNode head) {
		StringBuilder sb = new StringBuilder();

		while (head != null) {
			sb.append(head.val + ",");
			head = head.next;
		}
		return sb.toString();
	}

}