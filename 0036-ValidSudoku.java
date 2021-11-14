class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        // 标记 行 列 单元 是否出现 1-9 的数字
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] grids = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue ; 
                }
                int grid = (j / 3) * 3 + i / 3;
                if (isExist(rows[j], c) || isExist(columns[i], c) || isExist(grids[grid], c)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isExist(boolean[] contain, char c) {
        int index = c - '0' - 1;
        if (contain[index]) {
            return true;
        }
        contain[index] = true;
        return false;
    }
}
