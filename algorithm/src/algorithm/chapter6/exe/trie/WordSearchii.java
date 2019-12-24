package algorithm.chapter6.exe.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 【单词搜索ii】给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class WordSearchii {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		if (board != null && board.length > 0 && null != words && words.length > 0) {
			Set<String> res = new HashSet<>();

			Trie trie = new Trie();
			for (String val : words) {
				trie.insert(val);
			}
			int m = board.length;
			int n = board[0].length;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					boolean[][] visited = new boolean[m][n];
					findWord(i, j, m, n, board, trie, "", res, visited);
				}
			}
			return new ArrayList<>(res);
		}
		return result;
	}

	private void findWord(int i, int j, int m, int n, char[][] board, Trie trie, String word, Set<String> result,
			boolean[][] visited) {
		if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j] == true) {
			return;
		}
		word += board[i][j];

		if (!trie.startWith(word)) {
			return;
		}
		if (trie.find(word)) {
			result.add(word);
		}
		visited[i][j] = true;
		findWord(i + 1, j, m, n, board, trie, word, result, visited);
		findWord(i - 1, j, m, n, board, trie, word, result, visited);
		findWord(i, j - 1, m, n, board, trie, word, result, visited);
		findWord(i, j + 1, m, n, board, trie, word, result, visited);
		visited[i][j] = false;

	}

	class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		void insert(String word) {
			if (null != word && word.length() > 0) {
				TrieNode node = root;
				for (int i = 0; i < word.length(); i++) {
					char ch = word.charAt(i);
					if (!node.contains(ch)) {
						node.put(ch, new TrieNode());
					}
					node = node.get(ch);
				}
				node.isEnd = true;
			}
		}

		boolean startWith(String word) {
			return searchPrefix(word) != null;
		}

		private TrieNode searchPrefix(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (node.contains(ch)) {
					node = node.get(ch);
				} else {
					return null;
				}
			}
			return node;
		}

		boolean find(String word) {
			TrieNode node = searchPrefix(word);
			return node != null && node.isEnd == true;
		}

		class TrieNode {
			private TrieNode[] element;
			boolean isEnd;

			TrieNode() {
				element = new TrieNode[26];
			}

			public TrieNode get(char ch) {
				if (contains(ch)) {
					return element[ch - 'a'];
				}
				return null;
			}

			public void put(char ch, TrieNode trieNode) {
				element[ch - 'a'] = trieNode;
			}

			public boolean contains(char ch) {
				return element[ch - 'a'] != null;
			}
		}
	}

	public static void main(String[] args) {
		/**
		 * [["a","b"],["a","a"]] ["aba","baa","bab","aaab","aaa","aaaa","aaba"]
		 */
		WordSearchii a = new WordSearchii();
		String[] words = new String[] { "aaa", "aaab" };
		char[][] board = new char[][] { { 'a', 'b' }, { 'a', 'a' } };
		List<String> result = a.findWords(board, words);
		for (String re : result) {
			System.out.println(re);
		}
	}
}
