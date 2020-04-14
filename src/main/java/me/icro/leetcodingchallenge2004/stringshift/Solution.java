package me.icro.leetcodingchallenge2004.stringshift;

import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/4/14
 **/
public class Solution {
    public String stringShift(String s, int[][] shift) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            linkedList.addLast(s.substring(i, i + 1));
        }
        for (int i = 0; i < shift.length; i++) {
            if (0 == shift[i][0]) {
                for (int i1 = 0; i1 < shift[i][1]; i1++) {
                    linkedList.addLast(linkedList.pollFirst());
                }
            } else {
                for (int i1 = 0; i1 < shift[i][1]; i1++) {
                    linkedList.addFirst(linkedList.pollLast());
                }
            }
        }
        return String.join("", linkedList);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().stringShift("abc", new int[][]{
                new int[] {0, 1},
                new int[] {1, 2}
        }));

        System.out.println(new Solution().stringShift("abcdefg", new int[][]{
                new int[] {1, 1},
                new int[] {1, 1},
                new int[] {0, 2},
                new int[] {1, 3}
        }));
    }
}
