class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dfs(board, word, 0, r, c);
                if (isExist) {
                    return true;
                }
            }
        }
        return isExist;
    }

    private boolean isExist = false;
    private void dfs(char[][] board, String word, int i, int r, int c) {
        if (isExist) {
            return;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        if (board[r][c] != word.charAt(i)) {
            return;
        }
        if (i == word.length() - 1) {
            isExist = true;
            return;
        }
        board[r][c] ^= 256; // visited
        dfs(board, word, i + 1, r + 1, c);
        dfs(board, word, i + 1, r - 1, c);
        dfs(board, word, i + 1, r, c + 1);
        dfs(board, word, i + 1, r, c - 1);
        board[r][c] ^= 256;
    }
}
