package me.icro.problems.t52totalnqueens;

/**
 * @author lin
 * @version v 0.1 2020/8/6
 **/
public class Solution2 {
    int count = 0, mask;

    public int totalNQueens(int n) {
        mask = (1 << n) - 1;
        backtrack(n, 0, 0, 0, 0);
        return count;
    }

    void backtrack(int n, int level, int col, int left, int right) {
        if (level == n) {
            count++;
        } else {
            int bitmap = mask & ~(col | left | right);
            while (bitmap != 0) {
                // 获取最低位1
                int bit = bitmap & -bitmap;
                backtrack(n, level + 1, col | bit, (left | bit) << 1, (right | bit) >> 1);
                bitmap &= bitmap - 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().totalNQueens(4));
    }
}
