package algorithm.chapter3.second.dfsbfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 【433. 最小基因变化】一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 现在给定3个参数 — start, end,
 * bank，分别代表起始基因序列，目标基因序列及基因库， 请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * 注意: 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 所有的目标基因序列必须是合法的。 假定起始基因序列与目标基因序列是不一样的。 示例
 * 1: start: "AACCGGTT" end: "AACCGGTA" bank: ["AACCGGTA"] 返回值: 1
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_433_519 {
	static char[] value = new char[] { 'A', 'C', 'G', 'T' };

	public int minMutation(String start, String end, String[] bank) {
		if (null != bank && bank.length > 0) {
			Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
			if (!bankSet.contains(end)) {
				return -1;
			}
			int count = 0;
			Deque<String> queue = new ArrayDeque<>();
			queue.add(start);
			while (queue.size() > 0) {
				int size = queue.size();
				count++;
				for (int i = 0; i < size; i++) {
					String curValue = queue.pollFirst();
//					bankSet.remove(curValue);
					char[] curValueArr = curValue.toCharArray();
					for (int j = 0; j < curValueArr.length; j++) {
						char temp = curValueArr[j];
						for (char ch : value) {
							if (ch != temp) {
								curValueArr[j] = ch;
								String changeValue = String.valueOf(curValueArr);
								if (!bankSet.contains(changeValue)) {
									continue;
								} else {
									if (changeValue.equals(end)) {
										return count;
									} else {
										queue.addLast(changeValue);
									}
								}
							}
						}
						curValueArr[j] = temp;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		LeetCode_433_519 a = new LeetCode_433_519();
		String[] bank = new String[] { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
		System.out.println(a.minMutation("AACCGGTT", "AACCGGTA", bank));
	}
}
