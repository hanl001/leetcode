class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        helper(0, 0, m, n, k, visited);
        return count;
    }

    private int count = 0;
    private void helper(int i, int j, int m, int n, int k, boolean[][] visited) {
         if (i < 0 || i >= m || j < 0 || j >= n || getcurK(i, j) > k) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        count++;
        helper(i - 1, j, m, n, k, visited);
        helper(i + 1, j, m, n, k, visited);
        helper(i, j - 1, m, n, k, visited);
        helper(i, j + 1, m, n, k, visited);
    }

    private int getcurK(int i, int j) {
        int k = 0;
        while (i > 0) {
            k += i % 10;
            i /= 10;
        }
        while (j > 0) {
            k += j % 10;
            j /= 10;
        }
        return k;
    }
}
