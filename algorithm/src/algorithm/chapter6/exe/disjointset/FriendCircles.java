package algorithm.chapter6.exe.disjointset;

/**
 * 【547. 朋友圈】班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是
 * C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。 给定一个 N *
 * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。 示例 1: 输入: [[1,1,0], [1,1,0], [0,0,1]]
 * 输出: 2 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。 第2个学生自己在一个朋友圈。所以返回2。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class FriendCircles {
	public int findCircleNum(int[][] M) {
		if (M != null && M.length > 0) {
			UnionFind unionFind = new UnionFind(M.length);
			for (int i = 0; i < M.length; i++) {
				for (int j = 0; j < M[0].length; j++) {
					if (i != j && M[i][j] == 1) {
						unionFind.union(i, j);
					}
				}
			}

			return unionFind.count;
		}
		return 0;
	}

	class UnionFind {
		private int count = 0;
		private int[] parent;

		UnionFind(int m) {
			count = m;
			parent = new int[m];
			for (int i = 0; i < m; i++) {
				parent[i] = i;
			}
		}

		public void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ) {
				return;
			}
			parent[rootP] = rootQ;
			count--;
		}

		public int find(int p) {
			while (p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}
	}

	public static void main(String[] args) {
		FriendCircles a = new FriendCircles();
		int[][] M = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(a.findCircleNum(M));
	}
}
