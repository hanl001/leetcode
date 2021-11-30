class Solution {
    public String tictactoe(String[] board) {
        boolean hasSpace = false;
        char curDiagonalCh = 'B'; // begin
        char curInverseDiagonalCh = 'B';
        for (int i = 0; i < board.length; i++) {
            char curRowCh = 'B';
            char curColCh = 'B';
            for (int j = 0; j < board.length; j++) {
                // check row
                char rowCh = board[i].charAt(j);
                if (rowCh == ' ') {
                    hasSpace = true; // log space status
                    curRowCh = 'S'; // skip
                } else if (curRowCh != 'S') {
                    if (j == board.length - 1 && (curRowCh == rowCh || curRowCh == 'B')) {
                        return Character.toString(rowCh);
                    } else if (curRowCh == 'B') {
                        curRowCh = rowCh;
                    } else if (curRowCh != rowCh) {
                        curRowCh = 'S'; // skip
                    }
                }
                // check col
                char colCh = board[j].charAt(i);
                if (colCh == ' ') {
                    curColCh = 'S'; // skip
                } else if (curColCh != 'S') {
                    if (j == board.length - 1 && (curColCh == colCh || curColCh == 'B')) {
                        return Character.toString(colCh);
                    } else if (curColCh == 'B') {
                        curColCh = colCh;
                    } else if (curColCh != colCh) {
                        curColCh = 'S'; // skip
                    }
                }
            }

            // check diagonal
            char diagonalCh = board[i].charAt(i);
            if (diagonalCh == ' ') {
                curDiagonalCh = 'S'; // skip
            } else if (curDiagonalCh != 'S') {
                if (i == board.length - 1 && (curDiagonalCh == diagonalCh || curDiagonalCh == 'B')) {
                    return Character.toString(diagonalCh);
                } else if (curDiagonalCh == 'B') {
                    curDiagonalCh = diagonalCh;
                } else if (curDiagonalCh != diagonalCh) {
                    curDiagonalCh = 'S'; // skip
                }
            }
            
            // check inverse diagonal
            char inverseDiagonalCh = board[i].charAt(board.length - 1 - i);
            if (inverseDiagonalCh == ' ') {
                curInverseDiagonalCh = 'S'; // skip
            } else if (curInverseDiagonalCh != 'S') {
                if (i == board.length - 1 && (curInverseDiagonalCh == inverseDiagonalCh || curInverseDiagonalCh == 'B')) {
                    return Character.toString(inverseDiagonalCh);
                } else if (curInverseDiagonalCh == 'B') {
                    curInverseDiagonalCh = inverseDiagonalCh;
                } else if (curInverseDiagonalCh != inverseDiagonalCh) {
                    curInverseDiagonalCh = 'S'; // skip
                }
            }
        }

        return hasSpace ? "Pending" : "Draw";
    }
}
