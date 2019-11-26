package algorithm.chapter6.template;

import java.util.List;

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
		return null;
	}

	public static void main(String[] args) {

		WordSearchii a = new WordSearchii();
		String[] words = new String[] { "oath", "pea", "eat", "rain" };
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		List<String> result = a.findWords(board, words);
		for (String re : result) {
			System.out.println(re);
		}

	}
}
