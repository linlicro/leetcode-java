package me.icro.problems.t58lengthoflastword;

/**
 * @author lin
 * @version v 0.1 2020/9/1
 **/
public class Solution {
    public int lengthOfLastWord(String s) {
        if (null == s) {
            return 0;
        }
        String[] arr = s.split(" +");
        if (0 == arr.length) {
            return 0;
        }
        return arr[arr.length - 1].length();
    }
}
