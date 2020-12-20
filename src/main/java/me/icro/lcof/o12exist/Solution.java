package me.icro.lcof.o12exist;

/**
 * @author lin
 * @version v 0.1 2020/12/20
 **/
public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (helper(board, x, y, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x > board.length - 1) {
            return false;
        }
        if (y < 0 || y > board[0].length - 1) {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }

        char tmp = board[x][y];
        board[x][y] = '0';
        boolean res = helper(board, x, y - 1, word, index + 1)
                || helper(board, x, y + 1, word, index + 1)
                || helper(board, x - 1, y, word, index + 1)
                || helper(board, x + 1, y, word, index + 1);

        board[x][y] = tmp;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'},
        }, "ABCCED"));
    }
}
