class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> borders = new ArrayList<>();
        int originalColor = grid[row][col];
        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0], y = node[1];
            boolean isBorder = false;
            for (int i = 0; i < 4; i++) {
                int nx = direc[i][0] + x, ny = direc[i][1] + y;
                if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                    isBorder = true;
                } else if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
            if (isBorder) {
                borders.add(new int[]{x, y});
            }
        }
        for (int i = 0; i < borders.size(); i++) {
            int x = borders.get(i)[0], y = borders.get(i)[1];
            grid[x][y] = color;
        }
        return grid;
    }
}
