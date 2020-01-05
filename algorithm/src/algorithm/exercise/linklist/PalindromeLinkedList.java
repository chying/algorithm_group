package algorithm.exercise.linklist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 【234. 回文链表】 https://leetcode-cn.com/problems/palindrome-linked-list/
 * 
 * @author chying
 *
 */
public class PalindromeLinkedList {
	/**
	 * 快慢指针
	 * 
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		Deque<Integer> deque = new LinkedList<>();
		while (slow != null && slow.next != null && fast != null && fast.next != null) {
			deque.add(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		// fast==null 证明 偶数个节点,slow 在后半段开始位置； fast.next==null 奇数个节点,slow 在中间节点 挪到下一位置
		// 开始比较,把中间节点 拿出来
		if (fast != null && fast.next == null) {
			slow = slow.next;
		}
		while (!deque.isEmpty() && slow != null) {
			if (deque.pollLast() != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeLinkedList a = new PalindromeLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(a.isPalindrome_1(head));
	}
	
	
    public boolean isPalindrome_1(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

}
