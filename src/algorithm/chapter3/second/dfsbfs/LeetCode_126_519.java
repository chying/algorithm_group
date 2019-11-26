package algorithm.chapter3.second.dfsbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 【126. 单词接龙 II】给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到
 * endWord 的最短转换序列。转换需遵循如下规则： 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典中的单词。 说明:
 * 如果不存在这样的转换序列，返回一个空列表。 所有单词具有相同的长度。 所有单词只由小写字母组成。 字典中不存在重复的单词。 你可以假设 beginWord
 * 和 endWord 是非空的，且二者不相同。 示例 1: 输入: beginWord = "hit", endWord = "cog", wordList
 * = ["hot","dot","dog","lot","log","cog"] 输出: [
 * ["hit","hot","dot","dog","cog"],   ["hit","hot","lot","log","cog"] ]
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_126_519 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		return null;
	}

	public static void main(String[] args) {
		LeetCode_126_519 a = new LeetCode_126_519();
//		/**
//		 * "hog" "cog" ["cog"]
//		 */
//		String beginWord = "hit";
//		String endWord = "cog";
//		String[] str = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
//		List<String> wordList = Arrays.asList(str);
//		List<List<String>> result = a.findLadders(beginWord, endWord, wordList);
//		for (List<String> list : result) {
//			System.out.println(list.toString());
//		}

		Object key = new Object();
		int hashCode = key.hashCode();
		System.out.println(hashCode);
		System.out.println((16 - 1) & hash1(key));
		System.out.println((16 - 1) & hashCode);

	}

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
	}

	static final int hash1(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	static final int hash2(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode());
	}
}
