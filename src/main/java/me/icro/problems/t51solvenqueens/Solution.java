package me.icro.problems.t51solvenqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/6/9
 **/
public class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        if (0 >= n) {
            return null;
        }
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backstrack(board, 0);
        return res;
    }

    private void backstrack(char[][] board, int level) {
        if (level == board.length) {
            res.add(charToString(board));
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

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }


}
