package me.icro.lcof.o13movingcount;

import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/12/20
 **/
public class Solution {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        LinkedList<int[]> linkedList = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        linkedList.addFirst(new int[]{0, 0});
        visited[0][0] = true;
        while (!linkedList.isEmpty()) {
            int[] node = linkedList.pollFirst();
            res++;

            int[] leftNode = new int[]{node[0], node[1] - 1};
            int[] rightNode = new int[]{node[0], node[1] + 1};
            int[] upNode = new int[]{node[0] - 1, node[1]};
            int[] downNode = new int[]{node[0] + 1, node[1]};

            walk(linkedList, visited, leftNode, m, n, k);
            walk(linkedList, visited, rightNode, m, n, k);
            walk(linkedList, visited, upNode, m, n, k);
            walk(linkedList, visited, downNode, m, n, k);
        }
        return res;
    }

    private void walk(LinkedList<int[]> linkedList, boolean[][] visited, int[] node, int m, int n, int k) {
        if (accessible(node, m, n, k) && !visited[node[0]][node[1]]) {
            visited[node[0]][node[1]] = true;
            linkedList.addFirst(node);
        }
    }

    private boolean accessible(int[] node, int m, int n, int k) {
        int x = node[0], y = node[1];
        if (x < 0 || x > m - 1) {
            return false;
        }
        if (y < 0 || y > n - 1) {
            return false;
        }
        if (bitSum(x) + bitSum(y) > k) {
            return false;
        }
        return true;
    }

    private int bitSum(int val) {
        int res = 0;
        while (val > 0) {
            res += val % 10;
            val /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));
        System.out.println(new Solution().movingCount(3, 1, 0));
    }
}
