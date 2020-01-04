package algorithm.exercise.linklist;

/**
 * 【2. 两数相加】 https://leetcode-cn.com/problems/add-two-numbers/
 * 
 * @author chying
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(8);
//		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(4);

		// [0,9]
		ListNode result = a.addTwoNumbers_3(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public ListNode addTwoNumbers_3(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode result = head;
		int sum = 0;
		int plus = 0;
		while (l1 != null || l2 != null) {
			int x = 0, y = 0;
			if (l1 != null) {
				x = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				y = l2.val;
				l2 = l2.next;
			}
			sum = x + y + plus;
			plus = sum / 10;
			result.next = new ListNode(sum % 10);
			result = result.next;
		}
		if (plus == 1)
			result.next = new ListNode(plus);

		return head.next;
	}
}
