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
    private void helper(char[][] board, int col) {
        if (col == board.length) {
            List<String> item = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String v = String.valueOf(board[i]);
                item.add(v);
            }
            list.add(item);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isMatch(board, col, row)) {
                board[col][row] = 'Q';
                helper(board, col + 1);
                board[col][row] = '.';
            }
        }
    }

    private boolean isMatch(char[][] board, int col, int row) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][row] == 'Q' || board[col][i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= Math.min(col, row); i++) {
            if (board[col - i][row - i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i < Math.min(board.length - col, board.length - row); i++) {
            if (board[col + i][row + i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i < Math.min(col + 1, board.length - row); i++) {
            if (board[col - i][row + i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i < Math.min(board.length - col, row + 1); i++) {
            if (board[col + i][row - i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
