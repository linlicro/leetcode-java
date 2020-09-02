package me.icro.problems.t541reversestr;

/**
 * @author lin
 * @version v 0.1 2020/9/2
 **/
public class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().reverseStr("abcdefg", 2));
//        System.out.println(new Solution().reverseStr("abcdefg", 3));
        System.out.println(new Solution().reverseStr("abcdefg", 4));
    }
}
