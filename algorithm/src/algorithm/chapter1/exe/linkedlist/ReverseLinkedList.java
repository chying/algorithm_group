package algorithm.chapter1.exe.linkedlist;

/**
 * ��206. ��ת����תһ�������� ʾ��: ����: 1->2->3->4->5->NULL ���: 5->4->3->2->1->NULL ����:
 * ����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿ ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-linked-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public ListNode reverseList_Recurison(ListNode head) {
		 if (head == null || head.next == null) return head;
		    ListNode p = reverseList_Recurison(head.next);
		    head.next.next = head;
		    head.next = null;
		    return p;

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
		ListNode node = a.reverseList(l1);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

}
