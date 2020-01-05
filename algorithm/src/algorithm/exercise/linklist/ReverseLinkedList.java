package algorithm.exercise.linklist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【206. 反转链表】反转一个单链表。 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList a = new ReverseLinkedList();
		ListNode head = ListNode.getListNode();
		System.out.println(ListNode.printStr(a.reverseList_stack(head)));
	}

	public ListNode reverseList_1(ListNode head) {
		ListNode pre = null;
		ListNode p = head;
		while (p != null) {
			ListNode nextNode = p.next;
			p.next = pre;
			pre = p;
			p = nextNode;
		}
		return pre;
	}

	public ListNode reverseList_2(ListNode head) {
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

	public ListNode reverseList_3(ListNode head) {
		ListNode pre = null;
		ListNode p = head;
		while (p != null) {
			ListNode nextNode = p.next;
			p.next = pre;
			pre = p;
			p = nextNode;
		}
		return pre;
	}

	public ListNode reverseList_stack(ListNode head) {
		Deque<ListNode> deque = new ArrayDeque<>();
		while (head != null) {
			ListNode newNode=new ListNode(head.val);
			deque.add(newNode);
			head = head.next;
		}
		ListNode res=new ListNode(-1);
		ListNode p = res;
		while (!deque.isEmpty()) {
			p.next = deque.pollLast();
			p = p.next;
		}
		return res.next;
	}

}
