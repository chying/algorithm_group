package algorithm.exercise.linklist;

/**
 * 【61. 旋转链表】 https://leetcode-cn.com/problems/rotate-list/
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 示例 1: 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步: 5->1->2->3->4->NULL 向右旋转 2 步:
 * 4->5->1->2->3->NULL 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class RotateList {
	/**
	 * k大于链表长度 移动k%len次就行,倒数第k个位置
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		if (head.next == null) {
			return head;
		}
		// 计算链表长度 并将链表做成环
		int n = 1;
		ListNode p = head;
		while (p.next != null) {
			p = p.next;
			n++;
		}
		p.next = head;

		int i = 1;
		ListNode q = head;
		while (i < n - k % n) {
			q = q.next;
			i++;
		}

		ListNode newHead = q.next;
		q.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		RotateList a = new RotateList();
		ListNode p = new ListNode(1);
		p.next = new ListNode(2);
		p.next.next = new ListNode(3);
		p.next.next.next = new ListNode(4);
		p.next.next.next.next = new ListNode(5);
		System.out.println(ListNode.printStr(a.rotateRight(p, 7)));
	}

	public ListNode rotateRight_1(ListNode head, int k) {
		// base cases
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		// close the linked list into the ring
		ListNode old_tail = head;
		int n;
		for (n = 1; old_tail.next != null; n++)
			old_tail = old_tail.next;
		old_tail.next = head;

		// find new tail : (n - k % n - 1)th node
		// and new head : (n - k % n)th node
		ListNode new_tail = head;
		for (int i = 0; i < n - k % n - 1; i++)
			new_tail = new_tail.next;
		ListNode new_head = new_tail.next;

		// break the ring
		new_tail.next = null;

		return new_head;
	}

}
