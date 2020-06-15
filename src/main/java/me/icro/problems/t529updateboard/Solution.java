package me.icro.problems.t529updateboard;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/6/12
 **/
public class Solution {

    char mines = 'M';
    char black = 'B';
    char element = 'E';

    int[] dx = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        // case: M
        if (mines == board[click[0]][click[1]]) {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        // case: B or a number
        if (black == board[click[0]][click[1]] || Character.isDigit(board[click[0]][click[1]])) {
            return board;
        }

        // case: E
        if (element == board[click[0]][click[1]]) {
            int mCount = countMine(board, click);
            if (0 == mCount) {
                board[click[0]][click[1]] = black;
                for (int i = 0; i < dx.length; i++) {
                    int newClickX = click[0] + dx[i];
                    int newClickY = click[1] + dy[i];
                    if (newClickX >= 0 && newClickX < board.length && newClickY >= 0 && newClickY < board[0].length) {
                        if (element == board[newClickX][newClickY]) {
                            updateBoard(board, new int[]{newClickX, newClickY});
                        }
                    }
                }
            } else {
                board[click[0]][click[1]] = Character.forDigit(mCount, 10);
            }
        }

        return board;
    }

    private int countMine(char[][] board, int[] click) {
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            if (click[0] + dx[i] >= 0 && click[0] + dx[i] < board.length && click[1] + dy[i] >= 0 && click[1] + dy[i] < board[0].length) {
                if (mines == board[click[0] + dx[i]][click[1] + dy[i]]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'M', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'}
        };
        System.out.println(Arrays.deepToString(new Solution().updateBoard(board, new int[]{3, 0})));
    }
}
