package algorithm.chapter2.exe.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【字母异位词分组】给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 示例: 输入: ["eat", "tea",
 * "tan", "ate", "nat", "bat"], 输出: [ ["ate","eat","tea"], ["nat","tan"],
 * ["bat"] ] 链接：https://leetcode-cn.com/problems/group-anagrams
 * 
 * @author chying
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if (null != strs && strs.length > 0) {
			Map<String, List<String>> map = new HashMap<>();
			for (String str : strs) {
				String key = hashKey(str);
				if (map.containsKey(key)) {
					map.get(key).add(str);
				} else {
					List<String> subList = new ArrayList<>(Arrays.asList(str));
					map.put(key, subList);
				}
			}
			return new ArrayList<List<String>>(map.values());
		}
		return result;
	}

	private String hashKey(String str) {
		int[] nums = new int[26];
		if (null != str && str.length() > 0) {
			for (int i = 0; i < str.length(); i++) {
				nums[str.charAt(i) - 'a']++;
			}
		}
		return Arrays.toString(nums);
	}

	public static void main(String[] args) {
		GroupAnagrams a = new GroupAnagrams();
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
	}

	public List<List<String>> groupAnagrams1(String[] strs) {
		if (null != strs && strs.length > 0) {
			Map<String, List<String>> map = new HashMap<>();
			for (String s : strs) {
				char[] arr = s.toCharArray();
				Arrays.sort(arr);
				String key = String.valueOf(arr);
				if(!map.containsKey(key)) {
					map.put(key, new ArrayList<>());
				}
				map.get(key).add(s);
			}
			return new ArrayList<List<String>>(map.values());
		}
		return null;
	}
}
