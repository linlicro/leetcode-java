package me.icro.problems.t500_findwords;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2020/5/29
 **/
public class Solution {
    static String line1Strings = "QWERTYUIOPqwertyuiop";
    static String line2Strings = "ASDFGHJKLasdfghjkl";
    static String line3Strings = "ZXCVBNMzxcvbnm";
    static Map<Character, Integer> characterIntegerMap = new HashMap<>();
    static {
        for (char c : line1Strings.toCharArray()) {
            characterIntegerMap.put(c, 1);
        }
        for (char c : line2Strings.toCharArray()) {
            characterIntegerMap.put(c, 2);
        }
        for (char c : line3Strings.toCharArray()) {
            characterIntegerMap.put(c, 3);
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (null == word || 0 == word.length()) {
                continue;
            }
            Integer line = characterIntegerMap.get(word.charAt(0));
            boolean match = true;
            for (char c : word.toCharArray()) {
                if (!line.equals(characterIntegerMap.get(c))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}
