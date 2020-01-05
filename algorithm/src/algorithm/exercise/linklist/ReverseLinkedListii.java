package algorithm.exercise.linklist;

/**
 * ��92. ��ת���� II��https://leetcode-cn.com/problems/reverse-linked-list-ii/ ��ת��λ�� m
 * �� n ��������ʹ��һ��ɨ����ɷ�ת�� ˵��: 1 �� m �� n �� �����ȡ� ����: 1->2->3->4->5->NULL, m = 2, n=
 * 4 ���: 1->4->3->2->5->NULL
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
			// head�ڵ�����nxt�ڵ�֮�������֣�Ҳ��������ƶ�һλ
			head.next = nxt.next;
			// nxt�ڵ��ƶ�����Ҫ��ת�����ֵ��ײ�
			nxt.next = pre.next;
			pre.next = nxt;// pre����Ϊ��Ҫ��תͷ�ڵ��ǰ���ڵ�
		}
		return dummy.next;
	}
}
