package medium;

public class FindCircleNum_547 {
    public static void main(String[] args) {
        FindCircleNum_547 test = new FindCircleNum_547();
        int[][] M = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(test.findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {
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

}

class UnionFind {
    int count = 0;
    int[] parent;

    /**
     * 初始化
     *
     * @param n
     */
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 找出集合根节点
     *
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    /**
     * 如果x和y不在一个集合，合并x和y所在的两个集合。
     *
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        } else {
            parent[rootX] = rootY;
            count--;
        }
    }
}
