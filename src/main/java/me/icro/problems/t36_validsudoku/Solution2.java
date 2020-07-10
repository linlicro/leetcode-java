package me.icro.problems.t36_validsudoku;

/**
 * @author lin
 * @version v 0.1 2020/7/10
 **/
public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        int count = 9;
        boolean[][] rows = new boolean[count][count];
        boolean[][] cols = new boolean[count][count];
        boolean[][] boxes = new boolean[count][count];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }

                int val = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + j / 3;
                // 行、列、子块 是都已经存在该数字
                if (rows[i][val] || cols[j][val] || boxes[boxIndex][val]) {
                    return false;
                }
                rows[i][val] = true;
                cols[j][val] = true;
                boxes[boxIndex][val] = true;
            }
        }
        return true;
    }
}
