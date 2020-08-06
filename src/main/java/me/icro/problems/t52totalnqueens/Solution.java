package me.icro.problems.t52totalnqueens;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/8/6
 **/
public class Solution {

    int result = 0;

    public int totalNQueens(int n) {
        if (0 >= n) {
            return 0;
        }
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backstrack(board, 0);
        return result;
    }

    private void backstrack(char[][] board, int level) {
        if (level == board.length) {
            result++;
            return;
        }
        for (int i = 0; i < board[level].length; i++) {
            if (!isValid(board, level, i)) {
                continue;
            }
            board[level][i] = 'Q';
            backstrack(board, level + 1);
            board[level][i] = '.';
        }
    }

    private boolean isValid(char[][] board, int level, int col) {
        // check col
        for (char[] chars : board) {
            if ('Q' == chars[col]) {
                return false;
            }
        }
        // check upright
        for (int i = level - 1, j = col + 1; i >=0 && j < board.length; i--, j++) {
            if ('Q' == board[i][j]) {
                return false;
            }
        }
        // check upleft
        for (int i = level - 1, j = col - 1; i >=0 && j >=0; i--, j--) {
            if ('Q' == board[i][j]) {
                return false;
            }
        }
        return true;
    }
}
