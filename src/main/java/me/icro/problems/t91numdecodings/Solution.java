package me.icro.problems.t91numdecodings;

/**
 * 类 爬楼梯问题
 * @author lin
 * @version v 0.1 2020/7/8
 **/
public class Solution {
    public int numDecodings(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        if ('0' == chars[0]) {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if ('0' != chars[i]) {
                dp[i] = dp[i - 1];
            }
            int num = 10 * (chars[i-1] - '0') + (chars[i] - '0');
            if (num >=10 && num <=26) {
                dp[i] += 1== i ? 1 : dp[i - 2];
            }
        }
        return dp[chars.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("226"));
    }
}
