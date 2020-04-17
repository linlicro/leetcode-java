package me.icro.leetcodingchallenge2004.numislands;

/**
 * @author lin
 * @version v 0.1 2020/4/17
 **/
public class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if ('1' == grid[i][i1]) {
                    num++;
                    grid[i][i1] = '2';
                    cover(grid, i + 1, i1);
                    cover(grid, i, i1 + 1);
                    cover(grid, i - 1, i1);
                    cover(grid, i, i1 - 1);
                }
            }
        }
        return num;
    }

    void cover(char[][] grid, int x, int y) {
        if (x >= grid.length || x < 0) {
            return;
        }
        if (y >= grid[0].length || y < 0) {
            return;
        }
        if ('1' == grid[x][y]) {
            grid[x][y] = '2';
            cover(grid, x + 1, y);
            cover(grid, x, y + 1);
            cover(grid, x - 1, y);
            cover(grid, x, y - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        }));

        System.out.println(new Solution().numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        }));
    }
}
