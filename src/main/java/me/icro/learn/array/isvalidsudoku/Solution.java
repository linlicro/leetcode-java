package me.icro.learn.array.isvalidsudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
 *
 * @author Lin
 * @since 2019-04-29 11:15 AM
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (null == board) return false;

        //check x-axis
        for (int x = 0; x < 9; x++) {
            Set<Character> set = new HashSet<>();
            for (int y = 0; y < 9; y++) {
                if ('.' == board[x][y]) continue;
                if (set.contains(board[x][y])) return false;
                set.add(board[x][y]);
            }
        }

        //check y-axis
        for (int y = 0; y < 9; y++) {
            Set<Character> set = new HashSet<>();
            for (int x = 0; x < 9; x++) {
                if ('.' == board[x][y]) continue;
                if (set.contains(board[x][y])) return false;
                set.add(board[x][y]);
            }
        }

        // check 3*3
        for (int x_index = 0; x_index < 3; x_index++) {
            for (int y_index = 0; y_index < 3; y_index++) {
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < 9; i++) {
                    int x = i % 3 + 3 * x_index;
                    int y = i / 3 + 3 * y_index;
                    if ('.' == board[x][y]) continue;
                    if (set.contains(board[x][y])) return false;
                    set.add(board[x][y]);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray(),
        };
        System.out.println(new Solution().isValidSudoku(board));

        char[][] board2 = new char[][]{
                "83..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray(),
        };
        System.out.println(new Solution().isValidSudoku(board2));
    }
}
