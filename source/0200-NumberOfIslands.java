class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] partners = new int[m * n];
        int[] ranks = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int index = i * n + j;
                    partners[index] = index;
                    ranks[index] = 1;
                    count++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    int index = i * n + j;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        union(partners, ranks, index, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        union(partners, ranks, index, i * n + j - 1);
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        union(partners, ranks, index, (i + 1) * n + j);
                    }
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        union(partners, ranks, index, i * n + j + 1);
                    }
                }
            }
        }

        return count;
    }

    private int count = 0;
    // rank 可用节点个数或者节点高度表示 leetcode 速度没区别
    private void union(int[] partners, int[] ranks, int i, int j) {
        int fi = find(partners, i);
        int fj = find(partners, j);
        if (fi != fj) {
            if (ranks[fi] < ranks[fj]) {
                partners[fi] = fj;
                ranks[fj] += ranks[fi];
            } else {
                partners[fj] = fi;
                ranks[fi] += ranks[fj];
            }
            count--;
        }
    }

    private int find(int[] partners, int i) {
        while (partners[i] != i) {
            partners[i] = partners[partners[i]];
            i = partners[i];
        }
        return i;
    }
}
