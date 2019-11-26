package algorithm.chapter6.third;

/**
 * 【208. 实现 Trie (前缀树)】实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例: Trie trie = new Trie(); trie.insert("apple"); trie.search("apple"); // 返回
 * true trie.search("app"); // 返回 false trie.startsWith("app"); // 返回 true
 * trie.insert("app"); trie.search("app"); // 返回 true 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class Trie {
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

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		boolean re1 = trie.search("apple");
		System.out.println(re1);
		boolean re2 = trie.search("app");
		System.out.println(re2);
	}

	/**
	 * Your Trie object will be instantiated and called as such: Trie obj = new
	 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
	 * = obj.startsWith(prefix);
	 */
}
