package algorithm.exercise.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 【160. 相交链表】https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 
 * @author chying
 *
 */
public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (null != headA && headB != null) {
			Set<ListNode> set = new HashSet<>();
			ListNode p = headA;
			ListNode q = headB;
			while (p != null && q != null) {
				if (!set.add(p))
					return p;
				if (!set.add(q))
					return q;
				p = p.next;
				q = q.next;
			}

			while (p != null) {
				if (set.contains(p))
					return p;
				p = p.next;
			}
			while (q != null) {
				if (set.contains(q))
					return q;
				q = q.next;
			}

		}
		return null;
	}

	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists a = new IntersectionOfTwoLinkedLists();
		ListNode headA = new ListNode(3);
//		ListNode head1 = new ListNode(1);
//		ListNode head8 = new ListNode(8);
//		ListNode head4 = new ListNode(4);
//		ListNode head5 = new ListNode(5);

		ListNode headB = new ListNode(2);
//		ListNode head0 = new ListNode(3);
//		ListNode headB1 = new ListNode(1);
//		headA.next = head0;
//		head1.next = head8;
		headB.next = headA;
//		head0.next = headB1;
//		headB1.next = head8;
//		head8.next = head4;
//		head4.next = head5;
		/**
		 * 3[3][2,3]01
		 */
		System.out.println(a.getIntersectionNode_DoublePointer(headA, headB).val);
	}

	/**
	 * x1+y+x2=x2+y+x1 两个指针走完上述步数 正好在尾相遇.如果没有相交节点 那么都走到末尾
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode_DoublePointer(ListNode headA, ListNode headB) {
		if (null != headA && headB != null) {
			ListNode p = headA;
			ListNode q = headB;
			while (p != q) {
				p = p == null ? headB : p.next;
				q = q == null ? headA : q.next;
			}
			return p;
		}
		return null;
	}

	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		// boundary check
		if (headA == null || headB == null)
			return null;

		ListNode a = headA;
		ListNode b = headB;

		// if a & b have different len, then we will stop the loop after second
		// iteration
		while (a != b) {
			// for the end of first iteration, we just reset the pointer to the head of
			// another linkedlist
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}

		return a;
	}
}
