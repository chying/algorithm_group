package algorithm.chapter6.exe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class s {
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

	public static void main(String[] args) {
		s a = new s();
		String[] words = new String[] { "a" };
		char[][] board = new char[][] { { 'a','a'} };

		List<String> result = a.findWords(board, words);
		for (String re : result) {
			System.out.println(re);
		}

	}

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
