package algorithm.exercise.linklist;

/**
 * ��206. ��ת������תһ�������� ʾ��: ����: 1->2->3->4->5->NULL ���: 5->4->3->2->1->NULL ����:
 * ����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿ ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-linked-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 * @author chying
 *
 */
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		ListNode p = head;
		ListNode pre = null;
		while (p != null && p.next != null) {
			ListNode temp = p.next.next;
			p.next.next = p;
			p = p.next;
		}
		return null;
	}

	public static void main(String[] args) {
		ReverseLinkedList a = new ReverseLinkedList();
		ListNode head = ListNode.getListNode();
		System.out.println(ListNode.printStr(a.reverseList(head)));

	}

}
