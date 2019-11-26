package algorithm.chapter6.first;

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
	/**
	 * 将words 放到trie树中
	 * 
	 * @param board
	 * @param words
	 * @return
	 */
	Set<String> res = new HashSet<>();

	public List<String> findWords(char[][] board, String[] words) {
		if (null != words && null != board) {
			Trie trie = new Trie();
			for (String word : words) {
				trie.insert(word);
			}
			int m = board.length;
			int n = board[0].length;
			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					dfs(board, visited, "", i, j, trie);
				}
			}
			return new ArrayList<>(res);
		}
		return null;
	}

	private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			return;
		}
		if (visited[x][y]) {
			return;
		}
		str += board[x][y];
		if (!trie.startsWith(str)) {
			return;
		}
		if (trie.search(str)) {
			res.add(str);
		}
		visited[x][y] = true;
		dfs(board, visited, str, x - 1, y, trie);
		dfs(board, visited, str, x + 1, y, trie);
		dfs(board, visited, str, x, y + 1, trie);
		dfs(board, visited, str, x, y - 1, trie);
		visited[x][y] = false;
	}

//	public static void main(String[] args) {
//		WordSearchii a = new WordSearchii();
//		String[] words = new String[] { "oath", "pea", "eat", "rain" };
//		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
//				{ 'i', 'f', 'l', 'v' } };
//
//		List<String> result = a.findWords(board, words);
//		for (String re : result) {
//			System.out.println(re);
//		}
//
//	}

	class Trie {
		TrieNode root;

		/** Initialize your data structure here. */
		public Trie() {
			root = new TrieNode();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			if (null != word) {
				char[] ar = word.toCharArray();
				TrieNode element = root;
				for (char c : ar) {
					if (!element.containsKey(c)) {
						element.put(c, new TrieNode());
					}
					element = element.get(c);
				}
				element.setEnd();
			}
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			if (null != word) {
				char[] ar = word.toCharArray();
				TrieNode element = root;
				for (char c : ar) {
					if (element.containsKey(c)) {
						element = element.get(c);
					} else {
						return false;
					}
				}
				return element.isEnd;
			}

			return false;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {

			if (null != prefix) {
				char[] ar = prefix.toCharArray();
				TrieNode element = root;
				for (char c : ar) {
					if (element.containsKey(c)) {
						element = element.get(c);
					} else {
						return false;
					}
				}
				return true;
			}

			return false;

		}

		class TrieNode {
			TrieNode[] links;
			private boolean isEnd;

			public TrieNode() {
				links = new TrieNode[26];
			}

			public TrieNode get(char c) {
				return links[c - 'a'];
			}

			public boolean containsKey(char c) {
				return links[c - 'a'] != null;
			}

			public void put(char ch, TrieNode node) {
				links[ch - 'a'] = node;
			}

			public void setEnd() {
				this.isEnd = true;
			}

			public boolean isEnd() {
				return isEnd;
			}
		}
	}
}
