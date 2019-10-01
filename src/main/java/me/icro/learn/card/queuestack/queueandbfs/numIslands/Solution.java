package me.icro.learn.card.queuestack.queueandbfs.numIslands;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/872/
 *
 * @author Lin
 * @since 2019-10-01 5:00 PM
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (null == grid)
            return 0;
        int nums = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if ('1' == grid[y][x]) {
                    nums++;
                    cover(grid, x, y);
                }
            }
        }
        return nums;
    }

    void cover(char[][] grid, int x, int y) {
        grid[y][x] = '0';
        if (y + 1 < grid.length && '1' == grid[y + 1][x]) {
            cover(grid, x, y + 1);
        }
        if (x + 1 < grid[y].length && '1' == grid[y][x + 1]) {
            cover(grid, x + 1, y);
        }
        if (y - 1 >= 0 && '1' == grid[y - 1][x]) {
            cover(grid, x, y - 1);
        }
        if (x - 1 >= 0 && '1' == grid[y][x - 1]) {
            cover(grid, x - 1, y);
        }
    }

    public static void main(String[] args) {
        char[][] grid1 = new char[][]{
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray(),
        };
        System.out.println(new Solution().numIslands(grid1));

        char[][] grid2 = new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray(),
        };
        System.out.println(new Solution().numIslands(grid2));

        char[][] grid3 = new char[][]{
                "111".toCharArray(),
                "010".toCharArray(),
                "111".toCharArray(),
        };
        System.out.println(new Solution().numIslands(grid3));
    }
}
