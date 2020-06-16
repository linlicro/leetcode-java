package me.icro.problems.t367isperfectsquare;

/**
 * @author lin
 * @version v 0.1 2020/6/16
 **/
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (1 == num) {
            return true;
        }
        int left = 0;
        int right = num / 2 + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Math.pow(mid, 2) == num) {
                return true;
            }
            if (Math.pow(mid, 2) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(16));
        System.out.println(new Solution().isPerfectSquare(808201));
        System.out.println(new Solution().isPerfectSquare(14));
        System.out.println(new Solution().isPerfectSquare(1));
        System.out.println(new Solution().isPerfectSquare(2147483647));
    }
}
