package algorithm.exercise.topN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 【347. 前 K 个高频元素】 https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 
 * @author chying
 *
 */
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<NumNode> queue = new PriorityQueue<NumNode>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

		for (Map.Entry<Integer, Integer> node : map.entrySet()) {
			NumNode numNode = new NumNode(node.getKey(), node.getValue());
			queue.add(numNode);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		while (!queue.isEmpty()) {
			result.add(queue.poll().num);
		}
		return result;
	}

	final static class NumNode implements Comparable<NumNode> {
		int num;
		int count;

		NumNode(int num, int count) {
			this.num = num;
			this.count = count;
		}

		public static int compare(int x, int y) {
			return (x < y) ? -1 : ((x == y) ? 0 : 1);
		}

		@Override
		public int compareTo(NumNode o) {
			return this.count - o.count;
		}
	}

	public static void main(String[] args) {
		TopKFrequentElements a = new TopKFrequentElements();
		int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6 };
		System.out.println(a.topKFrequent(nums, 10));
	}

	public List<Integer> topKFrequent_short(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
		for (Map.Entry<Integer, Integer> node : map.entrySet()) {

			queue.add(node.getKey());
			if (queue.size() > k) {
				queue.poll();
			}
		}
		while (!queue.isEmpty()) {
			result.add(queue.poll());
		}
		return result;

	}
}
