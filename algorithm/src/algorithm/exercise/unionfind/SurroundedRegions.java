package algorithm.exercise.unionfind;

/**
 * ��130. ��Χ�Ƶ����� ����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O���� �ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' ��
 * 'X' ��䡣 https://leetcode-cn.com/problems/surrounded-regions/
 * 
 * @author chying
 *
 */
public class SurroundedRegions {
	private int m = 0;
	private int n = 0;

	public void solve(char[][] board) {
		if (null != board) {
			m = board.length;
			n = board[0].length;
			UnionFind uf = new UnionFind(m * n);

		}
	}

	class UnionFind {
		private int[] parents;

		UnionFind(int len) {
			for (int i = 0; i < len; i++) {
				parents[i] = i;
			}
		}

		void union(int m, int n) {
			int mp = find(m);
			int np = find(n);
			if (mp == np) {
				return;
			}
			parents[mp] = np;
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
		SurroundedRegions a = new SurroundedRegions();
		char[][] board = new char[][] { { 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' } };
		a.solve(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(String.valueOf(board[i]));
		}
	}
}
