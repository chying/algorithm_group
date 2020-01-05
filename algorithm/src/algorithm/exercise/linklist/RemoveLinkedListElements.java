package algorithm.exercise.linklist;

/**
 * ¡¾203. ÒÆ³ýÁ´±íÔªËØ¡¿ https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 
 * @author chying
 *
 */
public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode res = head;
		if (head != null) {
			ListNode pre = res;
			ListNode p = res.next;
			while (p != null) {
				if (p.val == val) {
					pre.next = p.next;
				} else {
					pre = pre.next;
				}
				p = p.next;

			}
			if (res.val == val) {
				res = res.next;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		RemoveLinkedListElements a = new RemoveLinkedListElements();
		ListNode p = new ListNode(1);
		p.next = new ListNode(2);
		p.next.next = new ListNode(3);
		p.next.next.next = new ListNode(4);
		p.next.next.next.next = new ListNode(3);
		System.out.println(ListNode.printStr(a.removeElements_1(p, 3)));
	}

	public ListNode removeElements_1(ListNode head, int val) {
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;

		ListNode prev = sentinel, curr = head;
		while (curr != null) {
			if (curr.val == val)
				prev.next = curr.next;
			else
				prev = curr;
			curr = curr.next;
		}
		return sentinel.next;
	}

}
