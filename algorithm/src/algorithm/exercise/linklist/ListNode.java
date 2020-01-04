package algorithm.exercise.linklist;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
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
}