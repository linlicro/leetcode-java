package me.icro.problems.t490_haspath;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lin
 * @version v 0.1 2020/3/22
 **/
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int[][] visited = new int[maze.length][maze[0].length];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (destination[0] == cur[0] && destination[1] == cur[1]) {
                return true;
            }
            // left
            if (0 <= cur[1] - 1 && 0 == maze[cur[0]][cur[1] - 1]) {
                int x = cur[1] - 1;
                int y = cur[0];
                while (true) {
                    if (0 == x || 1 == maze[y][x - 1]) {
                        if (0 == visited[y][x]) {
                            int[] left = new int[]{y, x};
                            queue.add(left);
                        }
                        break;
                    }
                    x--;
                }
            }
            // right
            if (maze[0].length > cur[1] + 1 && 0 == maze[cur[0]][cur[1] + 1]) {
                int x = cur[1] + 1;
                int y = cur[0];
                while (true) {
                    if (maze[0].length - 1 == x || 1 == maze[y][x + 1]) {
                        if (0 == visited[y][x]) {
                            int[] right = new int[]{y, x};
                            queue.add(right);
                        }
                        break;
                    }
                    x++;
                }
            }
            // up
            if (0 <= cur[0] - 1 && 0 == maze[cur[0] - 1][cur[1]]) {
                int x = cur[1];
                int y = cur[0] - 1;
                while (true) {
                    if (0 == y || 1 == maze[y - 1][x]) {
                        if (0 == visited[y][x]) {
                            int[] up = new int[]{y, x};
                            queue.add(up);
                        }
                        break;
                    }
                    y--;
                }
            }
            // down
            if (maze.length > cur[0] + 1 && 0 == maze[cur[0] + 1][cur[1]]) {
                int x = cur[1];
                int y = cur[0] + 1;
                while (true) {
                    if (maze.length - 1 == y || 1 == maze[y + 1][x]) {
                        if (0 == visited[y][x]) {
                            int[] down = new int[]{y, x};
                            queue.add(down);
                        }
                        break;
                    }
                    y++;
                }
            }

            visited[cur[0]][cur[1]] = 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                new int[]{0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 1, 0},
                new int[]{1, 1, 0, 1, 1},
                new int[]{0, 0, 0, 0, 0}
        };
        int[] start = new int[]{0, 4};
        int[] destination = new int[] {4, 4};
        System.out.println(new Solution().hasPath(maze, start, destination));
    }
}
