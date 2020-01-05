package algorithm.exercise.linklist;

/**
 * 【92. 反转链表 II】https://leetcode-cn.com/problems/reverse-linked-list-ii/ 反转从位置 m
 * 到 n 的链表。请使用一趟扫描完成反转。 说明: 1 ≤ m ≤ n ≤ 链表长度。 输入: 1->2->3->4->5->NULL, m = 2, n=
 * 4 输出: 1->4->3->2->5->NULL
 * 
 * @author chying
 *
 */
public class ReverseLinkedListii {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummuNode = new ListNode(-1);
		dummuNode.next = head;
		ListNode cur = dummuNode;
		int i = 0;
		while (i < m - 1) {
			cur = cur.next;
			i++;
		}
		ListNode pre = null;
		ListNode p = cur.next;
		while (i < n && p != null) {
			ListNode temp = p.next;
			p.next = pre;
			pre = p;
			p = temp;
			i++;
		}
		cur.next = pre;
		int j = m;
		while (j <= n) {
			cur = cur.next;
			j++;
		}
		cur.next = p;
		return dummuNode.next;
	}

	public static void main(String[] args) {
		ReverseLinkedListii a = new ReverseLinkedListii();
		ListNode head = ListNode.getListNode();
		System.out.println(ListNode.printStr(a.reverseBetween_1(head, 2, 4)));
	}

	public ListNode reverseBetween_1(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		for (int i = 1; i < m; ++i)
			pre = pre.next;
		head = pre.next;
		for (int i = m; i < n; ++i) {
			ListNode nxt = head.next;
			// head节点连接nxt节点之后链表部分，也就是向后移动一位
			head.next = nxt.next;
			// nxt节点移动到需要反转链表部分的首部
			nxt.next = pre.next;
			pre.next = nxt;// pre继续为需要反转头节点的前驱节点
		}
		return dummy.next;
	}
}
