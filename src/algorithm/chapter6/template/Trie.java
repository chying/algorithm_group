package algorithm.chapter6.template;

/**
 * 【208. 实现 Trie (前缀树)】实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例: Trie trie = new Trie(); 
 * trie.insert("apple"); 
 * trie.search("apple"); // 返回 true
 * trie.search("app"); // 返回 false 
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app"); 
 * trie.search("app"); // 返回 true 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class Trie {

	/** Initialize your data structure here. */
	public Trie() {

	}

	/** Inserts a word into the trie. */
	public void insert(String word) {

	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		return false;

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.search("apple");
		trie.search("app");
	}

	/**
	 * Your Trie object will be instantiated and called as such: Trie obj = new
	 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
	 * = obj.startsWith(prefix);
	 */
}
