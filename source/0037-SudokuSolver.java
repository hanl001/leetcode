class Solution {
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    updateMatchSystem(i, j, board[i][j], true);
                }
            }
        }
        helper(board, 0);
    }

    private boolean isSuccess = false;
    private char[] numArr = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private void helper(char[][] board, int k) {
        if (k == spaces.size()) {
            isSuccess = true;
            return;
        }
        int[] space = spaces.get(k);
        int i = space[0];
        int j = space[1];
        for (char num : numArr) {
            if (isMatch(board, i, j, num)) {
                board[i][j] = num;
                updateMatchSystem(i, j, board[i][j], true);
                helper(board, k + 1);
                if (isSuccess) {
                    return;
                }
                updateMatchSystem(i, j, board[i][j], false);
                board[i][j] = '.';
            }
        }
    }

    private boolean[][] rowSets = new boolean[9][9];
    private boolean[][] colSets = new boolean[9][9];
    private boolean[][] boxSets = new boolean[9][9];
    private void updateMatchSystem(int row, int col, char num, boolean isAdd) {
        int i = num - '1';
        int box = row / 3 * 3 + col / 3;
        rowSets[row][i] = isAdd;
        colSets[col][i] = isAdd;
        boxSets[box][i] = isAdd;
    }

    private boolean isMatch(char[][] board, int row, int col, char num) {
        int i = num - '1';
        if (rowSets[row][i]) {
            return false;
        }

        if (colSets[col][i]) {
            return false;
        }

        int box = row / 3 * 3 + col / 3;
        if (boxSets[box][i]) {
            return false;
        }

        return true;
    }

    //private boolean isMatch(char[][] board, int row, int col, char num) {
    //    for (int i = 0; i < 9; i++) {
    //        if (board[row][i] == num || board[i][col] == num) {
    //            return false;
    //        }
    //    }
    //    int i = row / 3 * 3;
    //    int j = col / 3 * 3;
    //    for (int k = 0; k < 3; k++) {
    //        for (int l = 0; l < 3; l++) {
    //            if (board[i + k][j + l] == num) {
    //                return false;
    //            }
    //        }
    //    }
    //    return true;
    //}
}
