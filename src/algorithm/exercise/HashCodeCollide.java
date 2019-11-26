package algorithm.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashCodeCollide {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static void main(String[] args) {
		TreeNode[] arr = new TreeNode[1000000];
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> co_map = new HashMap<>();
		for (Object key : arr) {
			key = new HashCodeCollide().new TreeNode(53);
			int hashCode = key.hashCode();
			System.out.println(hashCode);
			int val = (16 - 1) & hashCode;
			int co_val = (16 - 1) & hash1(key);
			putValue(map, val);
			putValue(co_map, co_val);
		}

		printMap(map);
		printMap(co_map);

	}

	private static void printMap(Map<Integer, Integer> map) {
		for (Entry<Integer, Integer> m : map.entrySet()) {
			System.out.println(m.getKey() + ":" + m.getValue());
		}
	}

	private static void putValue(Map<Integer, Integer> map, int val) {
		if (!map.containsKey(val)) {
			map.put(val, 0);
		}
		map.put(val, map.get(val) + 1);
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
