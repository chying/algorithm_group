package algorithm.chapter1.template.linkedlist;

/**
 * 【206. 反转链表】转一个单链表。 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class ReverseLinkedList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public static void main(String[] args) {
		ReverseLinkedList a = new ReverseLinkedList();
		ListNode l1 = new ReverseLinkedList().new ListNode(1);
		ListNode l2 = new ReverseLinkedList().new ListNode(2);
		ListNode l3 = new ReverseLinkedList().new ListNode(3);
		ListNode l4 = new ReverseLinkedList().new ListNode(4);
		ListNode l5 = new ReverseLinkedList().new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode node = a.reverseList1(l1);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public ListNode reverseList1(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public ListNode reverseList2(ListNode head) {
		return null;
	}
}
