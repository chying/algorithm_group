package algorithm.chapter6.exe.trie;

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
public class Trie2 {

	private TrieNode root;

	/** Initialize your data structure here. */
	public Trie2() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		if (null != word && word.length() > 0) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (!node.contains(ch)) {
					node.put(ch);
				}
				node = node.get(ch);
			}
			node.setEnd();
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char curLetter = word.charAt(i);
			if (node.contains(curLetter)) {
				node = node.get(curLetter);
			} else {
				return null;
			}
		}
		return node;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;

	}

	class TrieNode {
		private TrieNode[] links;

		boolean isEnd;

		TrieNode() {
			this.links = new TrieNode[26];
		}

		public TrieNode get(char ch) {
			if (contains(ch)) {
				return links[ch - 'a'];
			}
			return null;
		}

		boolean contains(char ch) {
			return links[ch - 'a'] != null;
		}

		void put(char ch) {
			if (!contains(ch)) {
				links[ch - 'a'] = new TrieNode();
			}
		}

		public void setEnd() {
			isEnd = true;
		}

		public boolean isEnd() {
			return isEnd;
		}
	}

	public static void main(String[] args) {
		Trie2 trie = new Trie2();
//		"insert","search","search","startsWith"
//		["ab"],["abc"],["ab"],["abc"],   
		trie.insert("ab");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("ab"));
		System.out.println(trie.startsWith("abc"));

//     "startsWith","insert","search","startsWith",
//		 ["ab"],["ab"],["abc"],["abc"]
		System.out.println(trie.startsWith("ab"));
		trie.insert("ab");
		System.out.println(trie.search("abc"));
		System.out.println(trie.startsWith("abc"));

//		"insert","search","startsWith"
//		["abc"],["abc"],["abc"]
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.startsWith("abc"));

	}

	/**
	 * Your Trie object will be instantiated and called as such: Trie obj = new
	 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
	 * = obj.startsWith(prefix);
	 */
}
