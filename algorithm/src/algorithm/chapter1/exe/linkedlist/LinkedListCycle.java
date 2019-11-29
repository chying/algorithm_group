package algorithm.chapter1.exe.linkedlist;

import java.util.HashSet;

/**
 * ��141. ������������һ�������ж��������Ƿ��л���
 * 
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л��� ʾ��
 * 1�� ���룺head = [3,2,0,-4], pos = 1 �����true ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/linked-list-cycle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 * @author chying
 *
 */
public class LinkedListCycle {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * ����ָ�뷨
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle1(ListNode head) {
		if (null != head) {
			ListNode p = head;
			ListNode q = head.next;
			while (p != null && q != null && q.next != null) {
				if (p == q) {
					return true;
				}
				p = p.next;
				q = q.next.next;
			}
		}
		return false;
	}

	/**
	 * hashSet�� ִ����ʱ : 3 ms , ������ java �ύ�л����� 26.78% ���û� �ڴ����� : 38 MB , ������ java
	 * �ύ�л����� 94.62% ���û�
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle2(ListNode head) {
		if (null != head) {
			ListNode p = head;
			HashSet<ListNode> set = new HashSet<>();
			while (p != null) {
				if (!set.add(p)) {
					return true;
				}
				p = p.next;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedListCycle a = new LinkedListCycle();
		ListNode node3 = new LinkedListCycle().new ListNode(3);
		ListNode node2 = new LinkedListCycle().new ListNode(2);
		ListNode node0 = new LinkedListCycle().new ListNode(0);
		ListNode node4 = new LinkedListCycle().new ListNode(-4);
		node3.next = node2;
		node2.next = node0;
		node0.next = node4;
		node4.next = node2;
		System.out.println(a.hasCycle2(node3));
	}
}
