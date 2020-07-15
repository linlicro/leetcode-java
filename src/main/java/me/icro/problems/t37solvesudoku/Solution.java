package me.icro.problems.t37solvesudoku;

/**
 * @author lin
 * @version v 0.1 2020/7/15
 **/
public class Solution {
    public void solveSudoku(char[][] board) {
        if (null == board) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' == board[i][j]) {
                    for (char x = '1'; x <= '9'; x++) {
                        if (isValid(board, i, j, x)) {
                            board[i][j] = x;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int column, char x) {
        for (int i = 0; i < 9; i++) {
            // row
            if (x == board[row][i]) {
                return false;
            }
            // column
            if (x == board[i][column]) {
                return false;
            }
            // box
            int boxRow = (row / 3) * 3;
            int boxColumn = (column / 3) * 3;
            if (x == board[boxRow + i / 3][boxColumn + i % 3]) {
                return false;
            }
        }
        return true;
    }


}
