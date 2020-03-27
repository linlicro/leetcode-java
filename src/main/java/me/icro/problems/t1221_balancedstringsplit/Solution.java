package me.icro.problems.t1221_balancedstringsplit;

/**
 * @author lin
 * @version v 0.1 2020/3/27
 **/
public class Solution {
    public int balancedStringSplit(String s) {
        int count = 0, tol = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                tol--;
            } else {
                tol++;
            }
            if (0 == tol) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new Solution().balancedStringSplit("RLLLLRRRLR"));
        System.out.println(new Solution().balancedStringSplit("LLLLRRRR"));
    }
}
