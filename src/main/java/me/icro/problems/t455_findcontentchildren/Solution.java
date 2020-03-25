package me.icro.problems.t455_findcontentchildren;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/3/25
 **/
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (0 == s.length || 0 == g.length){
            return 0;
        }
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (g[i] <= s[s.length - 1 - count]) {
                count++;
            }
            if (count == s.length) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[]{1, 2, 3}, new int[]{3, 1}));
        System.out.println(new Solution().findContentChildren(new int[]{1, 2, 3}, new int[]{}));
        System.out.println(new Solution().findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
    }
}
