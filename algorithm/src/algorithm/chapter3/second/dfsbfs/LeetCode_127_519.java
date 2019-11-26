package algorithm.chapter3.second.dfsbfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 【127. 单词接龙】给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则： 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典中的单词。 说明: 如果不存在这样的转换序列，返回
 * 0。 所有单词具有相同的长度。 所有单词只由小写字母组成。 字典中不存在重复的单词。 你可以假设 beginWord 和 endWord
 * 是非空的，且二者不相同。 示例 1: 输入: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"] 输出: 5 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_127_519 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		int path = 0;
		Deque<String> queue = new ArrayDeque<>();
		if (null != wordList && wordList.size() > 0) {
			queue.addLast(beginWord);
			while (queue.size() > 0) {
				int size = queue.size();
				path++;
				for (int i = 0; i < size; i++) {
					String curWord = queue.pollFirst();
					char[] curWordArr = curWord.toCharArray();
					for (int j = 0; j < curWordArr.length; j++) {
						char temp = curWordArr[j];
						for (char c = 'a'; c <= 'z'; c++) {
							if (c != temp) {
								curWordArr[j] = c;
								String changeStr = String.valueOf(curWordArr);
								if (!wordSet.contains(changeStr)) {
									continue;
								} else {
									if (changeStr.equals(endWord)) {
										return path + 1;
									} else {
										wordSet.remove(changeStr);
										queue.addLast(changeStr);
									}
								}
							}
						}
						curWordArr[j] = temp;
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		LeetCode_127_519 a = new LeetCode_127_519();
		/**
		 * "hog" "cog" ["cog"]
		 */
		String beginWord = "hog";
		String endWord = "cog";
		String[] str = new String[] { "cog" };

		List<String> wordList = Arrays.asList(str);

		System.out.println(a.ladderLength(beginWord, endWord, wordList));
	}

	public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		if (beginWord.equals(endWord))
			return 2;

		// 可能遇见的节点集
		Set<String> meets = new HashSet<>(wordList); // O(n)

		Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
		Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

		return this._search(1, beginSet, endSet, meets);
	}

	private int _search(int level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
		if (beginSet.size() == 0 || endSet.size() == 0)
			return 0;
		meets.removeAll(beginSet);
		level++;
		Set<String> nextLevelSet = new HashSet<>();
		for (String beginWord : beginSet) {
			char[] chars = beginWord.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char temp = chars[i];
				for (char ch = 'a'; ch < 'z'; ch++) {
					chars[i] = ch;
					String newWord = String.valueOf(chars);
					if (!meets.contains(newWord))
						continue;
					if (endSet.contains(newWord))
						return level;
					nextLevelSet.add(newWord);
				}
				chars[i] = temp;
			}
		}
		if (nextLevelSet.size() <= endSet.size()) {
			beginSet = nextLevelSet;
		} else {
			beginSet = endSet;
			endSet = nextLevelSet;
		}
		return this._search(level, beginSet, endSet, meets);
	}

}
