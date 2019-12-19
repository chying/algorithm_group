package algorithm.chapter3.exe.bfsdfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (null == wordList || wordList.size() == 0 || !wordList.contains(endWord)) {
			return 0;
		}
		Set<String> wordSet = new HashSet<>(wordList);
		int result = 0;
		Deque<String> deque = new ArrayDeque<>();
		deque.addFirst(beginWord);
		while (!deque.isEmpty()) {
			int size = deque.size();
			result++;
			for (int i = 0; i < size; i++) {
				char[] arr = deque.pollLast().toCharArray();
				for (int j = 0; j < arr.length; j++) {
					char old = arr[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c != old) {
							arr[j] = c;
							String key = String.valueOf(arr);
							if (endWord.equals(key)) {
								return result + 1;
							} else if (wordSet.contains(key)) {
								wordSet.remove(key);
								deque.addFirst(key);
							}
						}
					}
					arr[j] = old;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		WordLadder a = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(
				Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
		/**
		 * "hot" "dog" ["hot","dog"]
		 */
		System.out.println(a.ladderLength_DBFS(beginWord, endWord, wordList));
	}

	public int ladderLength_DBFS(String beginWord, String endWord, List<String> wordList) {
		if (null == wordList || wordList.size() == 0 || !wordList.contains(endWord)) {
			return 0;
		}
		Set<String> wordSet = new HashSet<>(wordList);
		Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
		Set<String> endSet = new HashSet<>(Collections.singleton(endWord));
		int result = 1;
		while (!beginSet.isEmpty()) {
			result++;
			Set<String> nextSet = new HashSet<>();
			for (String word : beginSet) {
				char[] arr = word.toCharArray();
				for (int j = 0; j < arr.length; j++) {
					char old = arr[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c != old) {
							arr[j] = c;
							String key = String.valueOf(arr);
							if (endSet.contains(key)) {
								return result;
							} else if (wordSet.contains(key)) {
								wordSet.remove(key);
								nextSet.add(key);
							}
						}
					}
					arr[j] = old;
				}
			}
			// 双向BFS
			if (endSet.size() < nextSet.size()) {
				beginSet = endSet;
				endSet = nextSet;
			} else {
				beginSet = nextSet;
			}
		}
		return 0;
	}
}
