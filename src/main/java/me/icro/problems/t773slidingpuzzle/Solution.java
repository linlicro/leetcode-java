package me.icro.problems.t773slidingpuzzle;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2020/7/24
 **/
public class Solution {

    private int[][] map = new int[][]{
            new int[]{1, 3},
            new int[]{0, 2, 4},
            new int[]{1, 5},
            new int[]{0, 4},
            new int[]{1, 3, 5},
            new int[]{2, 4},
    };

    public int slidingPuzzle(int[][] board) {
        int step = 0;
        LinkedList<String> linkedList = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                cur.append(board[i][j]);
            }
        }
        linkedList.addLast(cur.toString());
        while (!linkedList.isEmpty()) {
            List<String> nexts = new ArrayList<>();
            while (!linkedList.isEmpty()) {
                String node = linkedList.pollFirst();
                visited.add(node);
                String target = "123450";
                if (target.equals(node)) {
                    return step;
                }
                // 寻找下一步
                // 1. 定位 0 的索引
                // 2. 当索引为0，下一步可以移动 1 与 3
                // 3. 其他索引 > 1:0,2,4; 2:1,5; 3:0, 4; 4:1,3,5; 5:2,4
                int indexOfZero = node.indexOf('0');
                for (int i : map[indexOfZero]) {
                    String nextNode = swap(node, indexOfZero, i);
                    if (visited.contains(nextNode)) {
                        continue;
                    }
                    nexts.add(nextNode);
                }
            }
            linkedList.addAll(nexts);
            step++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().slidingPuzzle(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 0, 5}
        }));
        System.out.println(new Solution().slidingPuzzle(new int[][]{
                new int[]{1, 2, 3},
                new int[]{5, 4, 0}
        }));
        System.out.println(new Solution().slidingPuzzle(new int[][]{
                new int[]{4, 1, 2},
                new int[]{5, 0, 3}
        }));
    }
}
