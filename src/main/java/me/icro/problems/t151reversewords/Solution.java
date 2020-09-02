package me.icro.problems.t151reversewords;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author lin
 * @version v 0.1 2020/9/2
 **/
public class Solution {
    public String reverseWords(String s) {
        String[] ss = s.trim().split(" +");
        Collections.reverse(Arrays.asList(ss));
        return String.join(" ", ss);
    }
}
