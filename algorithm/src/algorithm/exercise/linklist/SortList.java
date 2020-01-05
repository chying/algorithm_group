package algorithm.exercise.linklist;

/**
 * °æ148. ≈≈–Ú¡¥±Ì°ø https://leetcode-cn.com/problems/sort-list/
 * 
 * @author chying
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tmp = slow.next;
		slow.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(tmp);
		ListNode h = new ListNode(0);
		ListNode res = h;
		while (left != null && right != null) {
			if (left.val < right.val) {
				h.next = left;
				left = left.next;
			} else {
				h.next = right;
				right = right.next;
			}
			h = h.next;
		}
		h.next = left == null ? right : left;
		return res.next;
	}

	public ListNode sortList__1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head.next, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tmp = slow.next;
		slow.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(tmp);
		ListNode h = new ListNode(0);
		ListNode res = h;
		while (left != null && right != null) {
			if (left.val < right.val) {
				h.next = left;
				left = left.next;
			} else {
				h.next = right;
				right = right.next;
			}
			h = h.next;
		}
		h.next = left != null ? left : right;
		return res.next;
	}

	public static void main(String[] args) {
		SortList a = new SortList();
		ListNode p = new ListNode(4);
		p.next = new ListNode(2);
		p.next.next = new ListNode(1);
		p.next.next.next = new ListNode(3);
		System.out.println(ListNode.printStr(a.sortList(p)));
	}
}
