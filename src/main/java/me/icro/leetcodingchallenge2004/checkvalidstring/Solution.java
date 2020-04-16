package me.icro.leetcodingchallenge2004.checkvalidstring;

import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/4/16
 **/
class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("(*)*)"));

        System.out.println(new Solution().checkValidString("((*)"));
        //
        System.out.println(new Solution().checkValidString("**(()"));

        System.out.println(new Solution().checkValidString("(*()"));
//        "((((*"
        System.out.println(new Solution().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }
}
