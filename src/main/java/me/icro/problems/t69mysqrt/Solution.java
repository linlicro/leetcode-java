package me.icro.problems.t69mysqrt;

/**
 * 注意：针对特殊测试用例，例如 2147395599
 * 注意2: 中位数要取 右中位数，以防死循环
 * @author lin
 * @version v 0.1 2020/6/16
 **/
public class Solution {
    public int mySqrt(int x) {
        // for case: 0
        long left = 0;
        // for case: 1
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(10));
    }
}
