package me.icro.problems.t557reversewords;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lin
 * @version v 0.1 2020/9/3
 **/
public class Solution {
    public String reverseWords(String s) {
        if (null == s) {
            return null;
        }
        String[] ss = s.split(" ");
        List<String> resList = Arrays.stream(ss).map(p -> new StringBuilder(p).reverse().toString()).collect(Collectors.toList());
        return String.join(" ", resList);
    }
}
