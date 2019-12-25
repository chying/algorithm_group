package algorithm.chapter6.exe.disjointset;

/**
 * 【130. 被围绕的区域】 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用
 * 'X' 填充。 https://leetcode-cn.com/problems/surrounded-regions/
 * 
 * @author chying
 *
 */
public class SurroundedRegions {

	private int rows;
	private int cols;

	public void solve(char[][] board) {
		if (board != null && board.length > 0) {
			rows = board.length;
			cols = board[0].length;
			// 用一个虚拟节点，边界上的O 的父节点 都是这个节点
			UnionFind uf = new UnionFind(rows * cols + 1);
			int dummyNode = rows * cols;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (board[i][j] == 'O') {
						if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
							uf.union(node(i, j), dummyNode);
						} else {
							if (i > 0 && board[i - 1][j] == 'O')
								uf.union(node(i, j), node(i - 1, j));
							if (i < rows - 1 && board[i + 1][j] == 'O')
								uf.union(node(i, j), node(i + 1, j));
							if (j > 0 && board[i][j - 1] == 'O')
								uf.union(node(i, j), node(i, j - 1));
							if (j < cols - 1 && board[i][j + 1] == 'O')
								uf.union(node(i, j), node(i, j + 1));
						}
					}
				}
			}

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (board[i][j] == 'O') {
						if (!uf.isConnected(node(i, j), dummyNode)) {
							board[i][j] = 'X';
						}
					}
				}
			}
		}
	}

	int node(int i, int j) {
		return i * cols + j;
	}

	class UnionFind {
		int parent[];
		int size[];

		UnionFind(int m) {
			parent = new int[m];
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

		}

		private int find(int p) {
			while (p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}

		boolean isConnected(int p, int q) {
			return find(p) == find(q);
		}
	}

	public static void main(String[] args) {
		SurroundedRegions a = new SurroundedRegions();
		char[][] board = new char[][] { { 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' } };
		a.solve_DFS(board);
		for (int i = 0; i < a.rows; i++) {
			System.out.println(String.valueOf(board[i]));
		}
	}

	public void solve_DFS(char[][] board) {
		if (board != null && board.length > 0) {
			rows = board.length;
			cols = board[0].length;
			int[][] visited = new int[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
						// 与她相邻节点 染色
						if (board[i][j] == 'O') {
							floodFill(visited, i, j, board);
						}
					}
				}
			}

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (board[i][j] == 'O') {
						board[i][j] = 'X';
					}
					if (board[i][j] == '#') {
						board[i][j] = 'O';
					}
				}
			}
		}
	}

	private void floodFill(int[][] visited, int i, int j, char[][] board) {
		if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1 || visited[i][j] == 1) {
			return;
		}
		visited[i][j] = 1;
		if (board[i][j] == 'O') {
			board[i][j] = '#';
		} else {
			return;
		}
		floodFill(visited, i + 1, j, board);
		floodFill(visited, i - 1, j, board);
		floodFill(visited, i, j + 1, board);
		floodFill(visited, i, j - 1, board);
		visited[i][j] = 0;
	}
}
