package algorithm.contest;

/**
 * ��5309. ��ͨ����Ĳ���������
 * https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 * @author chying
 *
 */
public class Contest_171_03 {

	public int makeConnected(int n, int[][] connections) {
		int row = connections.length;
		// n̫����� ��Ҫ����n-1����
		if (n - 1 > row) {
			return -1;
		}
		// ���鼯
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < row; i++) {
			uf.union(connections[i][0], connections[i][1]);
		}

		return uf.count - 1;
	}

	class UnionFind {
		int parent[];
		int size[];
		int count = 0;

		UnionFind(int m) {
			count = m;
			parent = new int[m];
			size = new int[m];
			for (int i = 0; i < m; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ) {
				return;
			}
			if (size[rootP] > size[rootQ]) {
				parent[rootQ] = rootP;
				size[rootP] += size[rootQ];
			} else {
				parent[rootP] = rootQ;
				size[rootQ] += size[rootP];
			}
			count--;
		}

		private int find(int p) {
			while (p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}
	}

	public static void main(String[] args) {
		Contest_171_03 a = new Contest_171_03();
		int[][] connections = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
		System.out.println(a.makeConnected(6, connections));
	}
	
	
}
