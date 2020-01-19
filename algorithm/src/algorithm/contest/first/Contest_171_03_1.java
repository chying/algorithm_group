package algorithm.contest.first;

/**
 * 【5309. 连通网络的操作次数】
 * https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 * 
 * @author chying
 *
 */
public class Contest_171_03_1 {

	class UnionFind {
		int[] parent;

		UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		void union(int i, int j) {
			int pi = findParent(i);
			int pj = findParent(j);
			if (pi != pj) {
				parent[i] = j;
			}
		}

		private int findParent(int p) {
			while (p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}

		public int getCount() {
			int count = 0;
			for (int i = 0; i < parent.length; i++) {
				if (i != parent[i]) {
					count++;
				}
			}
			return count;
		}
	}

	public int makeConnected(int n, int[][] connections) {
		int row = connections.length;
		// n台计算机 需要至少n-1条线
		if (n - 1 > row) {
			return -1;
		}
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < row; i++) {
			uf.union(connections[i][0], connections[i][1]);
		}

		return uf.getCount();
	}

	public static void main(String[] args) {
		Contest_171_03_1 a = new Contest_171_03_1();
		// 11
//		[[3,4],[5,6],[0,3],[0,5],[1,7],[0,4],[2,6],[1,6],[1,3],[3,7],[4,5],[3,5]]
//		int[][] connections = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
//		int[][] connections = new int[][] { { 3, 4 }, { 5, 6 }, { 0, 3 }, { 0, 5 }, { 1, 7 }, { 0, 4 }, { 2, 6 },
//				{ 1, 6 }, { 1, 3 }, { 3, 7 }, { 4, 5 }, { 3, 5 } };
		int[][] connections = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		System.out.println(a.makeConnected(4, connections));
	}

}
