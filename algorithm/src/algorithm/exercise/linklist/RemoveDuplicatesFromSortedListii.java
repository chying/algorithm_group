package algorithm.exercise.linklist;

/**
 * 【82. 删除排序链表中的重复元素 II】
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * @author chying
 *
 */
public class RemoveDuplicatesFromSortedListii {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy.next;
		ListNode q = dummy;
		int cur = p.val;
		int count = 0;
		while (p.next != null) {
			p = p.next;
			if (p.val != cur) {
				if (count != 0) {
					q.next = p;
					count = 0;
				}
				if (p.val != p.next.val) {
					q = q.next;
				}
				cur = p.val;
			} else {
				count++;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListii a = new RemoveDuplicatesFromSortedListii();
		ListNode p = new ListNode(1);
		p.next = new ListNode(1);
		p.next.next = new ListNode(3);
		p.next.next.next = new ListNode(3);
		p.next.next.next.next = new ListNode(5);
		System.out.println(ListNode.printStr(a.deleteDuplicates(p)));
	}
}
