class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, 0);
        return list;
    }

    private List<List<String>> list = new ArrayList<>();
    private void helper(char[][] board, int row) {
        if (row == board.length) {
            List<String> item = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String v = String.valueOf(board[i]);
                item.add(v);
            }
            list.add(item);
            return;
        }
        for (int col = 0; row < board.length; row++) {
            if (isMatch(board, row, col)) {
                board[row][col] = 'Q';
                helper(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isMatch(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q' || board[row][i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i < Math.min(board.length - row, board.length - col); i++) {
            if (board[row + i][col + i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i < Math.min(row + 1, board.length - col); i++) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i < Math.min(board.length - row, col + 1); i++) {
            if (board[row + i][col - i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
