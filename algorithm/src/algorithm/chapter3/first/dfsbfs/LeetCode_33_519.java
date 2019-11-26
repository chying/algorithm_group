package algorithm.chapter3.first.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class LeetCode_33_519 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		List<String> visited = new ArrayList<>();
		visited.add(beginWord);
		int count = 0;
		while (!queue.isEmpty()) {
			List<String> listNode = new ArrayList<>();
			while (!queue.isEmpty()) {
				listNode.addAll(getNearlyWord(queue.poll(), wordList, visited));
			}
			if (!listNode.contains(endWord)) {
				count++;
				queue.addAll(listNode);
			} else {
				// 开头+结尾
				return count + 2;
			}
		}
		return 0;
	}

	// 单词相同长度，单词中不出现重复单词
	private List<String> getNearlyWord(String targerWord, List<String> wordList, List<String> visited) {
		char[] targetArr = targerWord.toCharArray();
		List<String> result = new ArrayList<>();
		for (String word : wordList) {
			if (!visited.contains(word)) {
				int count = 0;
				char[] wordArr = word.toCharArray();
				for (int i = 0; i < wordArr.length; i++) {
					if (wordArr[i] == targetArr[i]) {
						count++;
					}
				}
				if (targerWord.length() - 1 == count) {
					result.add(word);
					visited.add(word);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode_33_519 a = new LeetCode_33_519();
		/**
		 * "lost" "miss" ["most","mist","miss","lost","fist","fish"]
		 */
		List<String> wordList = Arrays.asList(new String[] { "most", "mist", "miss", "lost", "fist", "fish" });
		int result = a.ladderLength("lost", "miss", wordList);

		/**
		 * beginWord = "hit", endWord = "cog", wordList =
		 * ["hot","dot","dog","lot","log","cog"]
		 */
//		List<String> wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
//		int result = a.ladderLength("hit", "cog", wordList);

		/**
		 * "leet" "code" ["lest","leet","lose","code","lode","robe","lost"]
		 */
//		List<String> wordList = Arrays.asList(new String[] { "lest", "leet", "lose", "code", "lode", "robe", "lost" });
//		int result = a.ladderLength("leet", "code", wordList);
		System.out.println(result);
	}
}
