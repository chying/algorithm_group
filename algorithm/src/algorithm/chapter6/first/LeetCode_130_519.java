package algorithm.chapter6.first;

/**
 * ��130. ��Χ�Ƶ����� ����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O���� �ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' ��
 * 'X' ��䡣 https://leetcode-cn.com/problems/surrounded-regions/
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
			//·��ѹ��
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
