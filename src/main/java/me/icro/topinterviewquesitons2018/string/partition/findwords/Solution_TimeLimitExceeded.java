package me.icro.topinterviewquesitons2018.string.partition.findwords;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/275/string/1141/
 *
 * @author Lin
 * @since 2019-08-01 9:43 AM
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (null == board || null == words)
            return res;
        if (0 == words.length)
            return res;

        for (String word : words) {
            char[][] board_copy = new char[board.length][board[0].length];
            helper(board, word, 0, 0, 0, res, board_copy);
        }

        return res;
    }

    private void helper(char[][] board, String word, int index, int x, int y, List<String> res, char[][] board_copy) {

        if (res.contains(word))
            return;

        if (index == word.length()) {
            res.add(word);
        } else if (0 == index) {

            for (; y < board.length; y++) {
                for (; x < board[0].length; x++) {
                    char ch = board[y][x];
                    if (word.substring(index, index + 1).equals(String.valueOf(ch))) {
                        board_copy[y][x] = 1;
                        // 往左边
                        helper(board, word, 1, x + 1, y, res, board_copy);
                        // 往下边
                        helper(board, word, 1, x, y + 1, res, board_copy);
                        // 往右边
                        helper(board, word, 1, x - 1, y, res, board_copy);
                        // 往上边
                        helper(board, word, 1, x, y - 1, res, board_copy);
                        board_copy[y][x] = 0;
                    }
                }
                x = 0;
            }
        } else {
            if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) {
                return;
            }
            char ch = board[y][x];
            if (word.substring(index, index + 1).equals(String.valueOf(ch)) && 0 == board_copy[y][x]) {
                board_copy[y][x] = 1;
                // 往左边
                helper(board, word, index + 1, x + 1, y, res, board_copy);
                // 往下边
                helper(board, word, index + 1, x, y + 1, res, board_copy);
                // 往右边
                helper(board, word, index + 1, x - 1, y, res, board_copy);
                // 往上边
                helper(board, word, index + 1, x, y - 1, res, board_copy);
                board_copy[y][x] = 0;
            }
        }
    }

    public static void main(String[] args) {

        //char[][] board = new char[][] {
        //        "oaan".toCharArray(),
        //        "etae".toCharArray(),
        //        "ihkr".toCharArray(),
        //        "iflv".toCharArray(),
        //};
        //String[] words = new String[] {
        //        "oath","pea","eat","rain"
        //};
        //
        //List<String> res = new Solution().findWords(board, words);
        //System.out.println(res.toString());

        //char[][] board = new char[][]{
        //        "a".toCharArray(),
        //};
        //String[] words = new String[]{
        //        "a"
        //};
        //
        //List<String> res = new Solution().findWords(board, words);
        //System.out.println(res.toString());

        //char[][] board = new char[][]{
        //        "aa".toCharArray(),
        //};
        //String[] words = new String[]{
        //        "aaa"
        //};
        //
        //List<String> res = new Solution().findWords(board, words);
        //System.out.println(res.toString());

        char[][] board = new char[][]{
                "ab".toCharArray(),
                "cd".toCharArray(),
        };
        String[] words = new String[]{
                "ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb"
        };

        List<String> res = new Solution().findWords(board, words);
        System.out.println(res.toString());

    }
}
