package algorithm.exercise.linklist;

/**
 * ��876. ������м��㡿 https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 
 * @author chying
 *
 */
public class MiddleOfTheLinkedList {
	/**
	 * ����ָ��
	 * 
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		MiddleOfTheLinkedList a = new MiddleOfTheLinkedList();
		ListNode p = new ListNode(1);
		p.next = new ListNode(2);
		p.next.next = new ListNode(3);
		p.next.next.next = new ListNode(4);
		p.next.next.next.next = new ListNode(5);
//		p.next.next.next.next.next = new ListNode(6);
//		/[1,2,3,4,5,6]
		System.out.println(ListNode.printStr(a.middleNode(p)));
	}
}
