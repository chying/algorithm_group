package algorithm.chapter1.exe.stackqueue;

/**
 * 【641设计循环双端队列�?�设计实现双端队列�?? 你的实现�?要支持以下操作：
 * MyCircularDeque(k)：构造函�?,双端队列的大小为k�? insertFront()：将�?个元素添加到双端队列头部�?
 * 如果操作成功返回true�? insertLast()：将�?个元素添加到双端队列尾部。如果操作成功返�? true�?
 * deleteFront()：从双端队列头部删除�?个元素�?�如果操作成功返�? true�?
 * deleteLast()：从双端队列尾部删除�?个元素�?�如果操作成功返�? true�?
 * getFront()：从双端队列头部获得�?个元素�?�如果双端队列为空，返回 -1�?
 * getRear()：获得双端队列的�?后一个元素�?� 如果双端队列为空，返回-1�? isEmpty()：检查双端队列是否为空�??
 * isFull()：检查双端队列是否满了�?? 示例�? MyCircularDeque circularDeque = new
 * MycircularDeque(3); // 设置容量大小�?3 circularDeque.insertLast(1); // 返回 true
 * circularDeque.insertLast(2); // 返回 true circularDeque.insertFront(3); // 返回
 * true circularDeque.insertFront(4); // 已经满了，返�? false circularDeque.getRear();
 * // 返回 2 circularDeque.isFull(); // 返回 true circularDeque.deleteLast(); // 返回
 * true circularDeque.insertFront(4);// 返回 true circularDeque.getFront(); // 返回
 * 4     提示：所有�?�的范围�? [1, 1000] 操作次数的范围为 [1, 1000] 请不要使用内置的双端队列库�??
 * 来源：力扣（LeetCode�? 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 
 * @author chying
 *
 */
public class MyCircularDeque {
	int[] element;
	int headIndex;
	int tailIndex;
	int numberCount;

	/** Initialize your data structure here. Set the size of the deque to be k. */
	public MyCircularDeque(int k) {
		if (k > 0) {
			element = new int[k];
			headIndex = k;
			tailIndex = -1;
			numberCount = 0;
		}
	}

	/**
	 * 将一个元素添加到双端队列头部。 如果操作成功返回true。
	 * 
	 * @return
	 */
	boolean insertFront(int val) {
		if (headIndex - 1 > tailIndex) {
			element[--headIndex] = val;
			numberCount++;
			return true;
		}
		return false;
	}

	/**
	 * 将一个元素添加到双端队列尾部。如果操作成功返回 true
	 * 
	 * @return
	 */
	boolean insertLast(int val) {
		if (tailIndex + 1 < headIndex) {
			element[++tailIndex] = val;
			numberCount++;
			return true;
		}
		return false;
	}

	/**
	 * 从双端队列头部删除一个元素。如果操作成功返回 true。
	 * 
	 * @return
	 */
	boolean deleteFront() {
		if (!isEmpty()) {
			if (headIndex != element.length) {
				element[headIndex++] = 0;
			} else {
				for (int i = 1; i < tailIndex + 1; i++) {
					element[i - 1] = element[i];
				}
				element[tailIndex] = 0;
				tailIndex--;
			}
			numberCount--;
			return true;
		}
		return false;
	}

	/**
	 * 从双端队列尾部删除一个元素。如果操作成功返回 true
	 * 
	 * @return
	 */
	boolean deleteLast() {
		if (!isEmpty()) {
			if (tailIndex != -1) {
				element[tailIndex--] = 0;
			} else {
				for (int i = element.length - 2; i > headIndex - 1; i--) {
					element[i + 1] = element[i];
				}
				element[headIndex] = 0;
				headIndex++;
			}
			numberCount--;
			return true;
		}
		return false;
	}

	/**
	 * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
	 * 
	 * @return
	 */
	int getFront() {
		if (!isEmpty()) {
			if (headIndex != element.length) {
				return element[headIndex];
			} else {
				return element[0];
			}
		}
		return -1;
	}

	/**
	 * 获得双端队列的最后一个元素。 如果双端队列为空，返回-1。
	 * 
	 * @return
	 */
	int getRear() {
		if (!isEmpty()) {
			if (tailIndex != -1) {
				return element[tailIndex];
			} else {
				return element[element.length - 1];
			}
		}
		return -1;
	}

	/**
	 * 检查双端队列是否为空。
	 * 
	 * @return
	 */
	boolean isEmpty() {
		if (numberCount == 0) {
			return true;
		}
		return false;
	}

	boolean isFull() {
		if (numberCount == element.length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// "MyCircularDeque","insertFront","getRear","deleteLast","getRear"
		MyCircularDeque a = new MyCircularDeque(77);
		a.insertFront(89);
		int rear = a.getRear();
		a.deleteLast();
		a.getRear();
		// "insertFront","insertFront","insertFront","insertFront","isFull"
		// [19],[23],[23],[82],[]
		a.insertFront(19);
		a.insertFront(23);
		a.insertFront(23);
		a.insertFront(82);
		a.isFull();
		// "insertFront","isFull","getRear","deleteLast",
		a.insertFront(45);
		a.isFull();
		int rear2 = a.getRear();
		a.deleteLast();
		//
		int front = a.getFront();
		System.out.println(front);
	}
}
