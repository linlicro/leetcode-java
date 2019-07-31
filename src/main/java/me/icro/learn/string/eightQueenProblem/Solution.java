package me.icro.learn.string.eightQueenProblem;


import java.util.Arrays;

/**
 * 描述: 八皇后问题
 *
 * 思路过程:
 *
 * step 1. 从第0行 0列开始放置一个皇后
 * step 2. 如果可以放，位置设置为1，然后放下一个皇后(下一行)
 * step 3. ...
 * step 4. 到第n个皇后(第n行)，没有位置可以放，此时回溯到上一层，重新放置
 *
 * 例子:
 * index = 6, 假设array[6][0]放置皇后
 * 下一步, putQueen(6 + 1)
 * 此时 array[7][*]没有位置可以放皇后，回溯上一步
 * array[6][0]设置成0，尝试放置array[6][0 + 1]位置，若可以放置，重复上述步骤；
 * 若 array[6][*] 没有位置可以放置，回溯至 5...
 *
 * @author Lin
 * @since 2019-07-31 2:17 PM
 */
public class Solution {
    private static final int QUEEN_NUMBER = 4; // 皇后数量
    private int[][] array = new int[QUEEN_NUMBER][QUEEN_NUMBER]; // 棋盘

    private int count_of_solutions = 0; // 解法的数量

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.putQueen(0);
    }

    public void putQueen(int index) {
        if (index == QUEEN_NUMBER) {
            // 找到一个解法
            count_of_solutions++;
            System.out.println(String.format("=============%s===============", count_of_solutions));
            for (int i = 0; i < QUEEN_NUMBER; i++) {
                System.out.println(Arrays.toString(array[i]));
            }
            System.out.println("=============================");
            System.out.println("");
        } else {
            for (int i = 0; i < QUEEN_NUMBER; i++) {
                if (check(index, i)) {
                    array[index][i] = 1;
                    putQueen(index + 1);
                    array[index][i] = 0; // 回溯
                }
            }
        }
    }

    /**
     * 检查是否可以在array[row][col]放置皇后
     *
     * 因放置皇后的时候，从上到下 逐行放置，所以 不用检查该行以及下面的行
     *
     * @param row
     * @param col
     * @return
     */
    private boolean check(int row, int col) {
        // 检查列是否有皇后
        for (int i = 0; i < row; i++) {
            if (1 == array[i][col]) {
                return false;
            }
        }

        // 检查左上对角线是否有皇后
        for (int y = row - 1, x = col - 1; y >=0 && x >= 0; y--, x--) {
            if (1 == array[y][x]) {
                return false;
            }
        }

        // 检查右上对角线是否有皇后
        for (int y = row - 1, x = col + 1; y >= 0 && x < QUEEN_NUMBER; y--, x++) {
            if (1 == array[y][x]) {
                return false;
            }
        }

        return true;
    }
}
