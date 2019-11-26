package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����ĸ��λ�ʷ��顿����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ����� ʾ��: ����: ["eat", "tea",
 * "tan", "ate", "nat", "bat"], ���: [ ["ate","eat","tea"], ["nat","tan"],
 * ["bat"] ] ���ӣ�https://leetcode-cn.com/problems/group-anagrams
 * 
 * @author chying
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}

	public List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			String key = getHash(s);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}

	private String getHash(String s) {
		char[] arr = s.toCharArray();
		int[] re = new int[26];
		for (char c : arr) {
			re[c - 'a']++;
		}
		return Arrays.toString(re);
	}

	public static void main(String[] args) {
		GroupAnagrams a = new GroupAnagrams();
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = a.groupAnagrams2(strs);
		for (List<String> s : result) {
			for (String aa : s) {
				System.out.println(aa + ",");
			}
			System.out.println("\n");
		}

	}
}
