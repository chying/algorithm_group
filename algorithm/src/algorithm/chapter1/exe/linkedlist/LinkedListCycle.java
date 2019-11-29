package algorithm.chapter1.exe.linkedlist;

import java.util.HashSet;

/**
 * 【141. 环形链表】给定一个链表，判断链表中是否有环。
 * 
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 示例
 * 1： 输入：head = [3,2,0,-4], pos = 1 输出：true 解释：链表中有一个环，其尾部连接到第二个节点。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
	 * 快慢指针法
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
	 * hashSet法 执行用时 : 3 ms , 在所有 java 提交中击败了 26.78% 的用户 内存消耗 : 38 MB , 在所有 java
	 * 提交中击败了 94.62% 的用户
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
