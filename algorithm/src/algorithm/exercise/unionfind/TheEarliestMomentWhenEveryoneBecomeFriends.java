package algorithm.exercise.unionfind;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 【1101. 彼此熟识的最早时间】
 * 
 * @author chying
 *
 */
public class TheEarliestMomentWhenEveryoneBecomeFriends {

	public int earliestAcq(int[][] logs, int N) {
		if (logs != null && logs.length > 0 && N > 0) {
			Arrays.sort(logs, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			UnionFind uf = new UnionFind(N);
			for (int i = 0; i < logs.length; i++) {
				uf.union(logs[i][1], logs[i][2]);
				if (uf.count == 1) {
					return logs[i][0];
				}
			}
		}
		return -1;
	}

	class UnionFind {
		private int[] parents;
		private int count = 0;

		UnionFind(int len) {
			parents = new int[len];
			for (int i = 0; i < len; i++) {
				parents[i] = i;
			}
			count = len;
		}

		void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ) {
				return;
			}
			parents[rootP] = parents[rootQ];
			count--;
		}

		private int find(int p) {
			while (p != parents[p]) {
				parents[p] = parents[parents[p]];
				p = parents[p];
			}
			return p;
		}

	}

	public static void main(String[] args) {
		TheEarliestMomentWhenEveryoneBecomeFriends a = new TheEarliestMomentWhenEveryoneBecomeFriends();
//		int[][] logs = new int[][] { { 20190101, 0, 1 }, { 20190104, 3, 4 }, { 20190107, 2, 3 }, { 20190211, 1, 5 },
//				{ 20190224, 2, 4 }, { 20190301, 0, 3 }, { 20190312, 1, 2 }, { 20190322, 4, 5 } };
		int[][] logs = new int[][] { { 3, 0, 3 }, { 4, 1, 2 }, { 0, 2, 0 }, { 2, 0, 2 }, { 8, 0, 3 }, { 1, 0, 1 },
				{ 5, 1, 2 }, { 7, 3, 1 }, { 6, 1, 0 }, { 9, 3, 0 } };
		int n = 4;
		System.out.println(a.earliestAcq(logs, n));
	}
}
