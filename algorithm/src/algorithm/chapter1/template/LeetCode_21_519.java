package algorithm.chapter1.template;

/**
 * 【合并两个有序链表】 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。  示例： 输入：1->2->4,
 * 1->3->4 输出：1->1->2->3->4->4 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 
 * @author chying
 *
 */
public class LeetCode_21_519 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode p = head;

		while ((l1 != null && l2 != null)) {
			if (l1.val > l2.val) {
				p.next = l2;
				l2 = l2.next;
			} else {
				p.next = l1;
				l1 = l1.next;
			}
			p = p.next;
		}

		if (l1 != null) {
			p.next = l1;
		}
		if (l2 != null) {
			p.next = l2;
		}
		return head.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		LeetCode_21_519 a = new LeetCode_21_519();
		ListNode l1 = new LeetCode_21_519().new ListNode(1);
		ListNode l2 = new LeetCode_21_519().new ListNode(1);
		ListNode l1_2 = new LeetCode_21_519().new ListNode(2);
		ListNode l1_4 = new LeetCode_21_519().new ListNode(4);
		ListNode l2_3 = new LeetCode_21_519().new ListNode(3);
		ListNode l2_4 = new LeetCode_21_519().new ListNode(4);
		l1.next = l1_2;
		l1_2.next = l1_4;
		l2.next = l2_3;
		l2_3.next = l2_4;

		ListNode result = a.mergeTwoLists(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}