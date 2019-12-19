package me.icro.topinterviewquesitons2018.heapstackqueue.decodeString;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/890/
 * <p>
 * 思路: 压栈方式，依次遍历字符串，把字符压入一个栈，当遇到']'时，推出字符 直到遇到']', 中括号内的子字符串记做 sub;
 * 再推出'k', 将sub * k后再压入;
 * 直到字符串遍历完成。
 *
 * @author Lin
 * @since 2019-12-19 2:22 PM
 */
public class Solution {

    public String decodeString(String s) {
        if (null == s || 0 == s.length())
            return "";

        LinkedList<String> characters = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ("]".equals(s.substring(i, i + 1))) {
                String sub = "";
                while (true) {
                    String pre_ch = characters.pollFirst();
                    if ("[".equals(pre_ch))
                        break;
                    sub = pre_ch + sub;
                }
                int k = 0;
                int j = 0;
                while (true) {
                    String sub_k = characters.peekFirst();
                    if (null == sub_k)
                        break;
                    if ('0' <= sub_k.charAt(0) && '9' >= sub_k.charAt(0)) {
                        k += Integer.parseInt(sub_k) * (0 == j ? 1 : Math.pow(10, j));
                        characters.pollFirst();
                    } else {
                        break;
                    }
                    j++;
                }
                characters.addFirst(String.format(String.format("%%%ds", k), " ").replace(" ", sub));
            } else {
                characters.addFirst(s.substring(i, i + 1));
            }
        }
        String result = "";
        String each = characters.pollLast();
        while (null != each) {
            result += each;
            each = characters.pollLast();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("100[leetcode]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
}
