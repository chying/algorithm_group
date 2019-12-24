package algorithm.exercise.list;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class ConvertBinaryNumberInAlinkedlisttointeger {
	
	public int getDecimalValue(ListNode head) {
		int result = 0;
		ListNode p = head;
		while (p != null) {
			result = result << 1;
			result += p.val;
			p = p.next;
		}
		return result;
	}

	public static void main(String[] args) {
		ConvertBinaryNumberInAlinkedlisttointeger a = new ConvertBinaryNumberInAlinkedlisttointeger();
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;

		System.out.println(a.getDecimalValue(node1));
	}
}
