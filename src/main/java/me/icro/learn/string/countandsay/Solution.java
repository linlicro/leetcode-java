package me.icro.learn.string.countandsay;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
 *
 * @author Lin
 * @since 2019-05-05 10:21 PM
 */
public class Solution {
    public String countAndSay(int n) {
        if (1 == n) return "1";
        String pre_say = countAndSay(n - 1);
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char cur_char = pre_say.charAt(0);
        for (int i = 0; i < pre_say.length(); i++) {
            if (cur_char == pre_say.charAt(i))
                count++;
            else {
                stringBuilder.append(count).append(cur_char);
                count = 1;
                cur_char = pre_say.charAt(i);
            }
        }
        if (0 != count)
            stringBuilder.append(count).append(cur_char);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(1));
        System.out.println(new Solution().countAndSay(2));
        System.out.println(new Solution().countAndSay(3));
        System.out.println(new Solution().countAndSay(4));
        System.out.println(new Solution().countAndSay(5));
        System.out.println(new Solution().countAndSay(6));
    }
}
