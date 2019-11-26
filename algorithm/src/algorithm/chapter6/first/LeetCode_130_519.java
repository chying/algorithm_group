package algorithm.chapter6.first;

/**
 * 【130. 被围绕的区域】 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用
 * 'X' 填充。 https://leetcode-cn.com/problems/surrounded-regions/
 * 
 * @author chying
 *
 */
public class LeetCode_130_519 {
	public void solve(char[][] board) {

	}

	public static void main(String[] args) {
		LeetCode_130_519 a = new LeetCode_130_519();
	}

	class Union {
		private int[] roots;

		public Union(int n) {
			roots = new int[n];
			for (int i = 0; i < n; i++) {
				roots[i] = i;
			}
		}

		private int findRoot(int i) {
			int root = i;
			while (root != roots[root]) {
				root = roots[root];
			}
			//路径压缩
			while (i != roots[root]) {
				int tmp = roots[i];
				roots[i] = root;
				i = tmp;
			}
			return root;
		}

		public boolean connected(int p, int q) {
			return findRoot(p) == findRoot(q);
		}

		public void union(int p, int q) {
			int qroot = findRoot(q);
			int proot = findRoot(p);

			roots[proot] = qroot;
		}
	}
}
