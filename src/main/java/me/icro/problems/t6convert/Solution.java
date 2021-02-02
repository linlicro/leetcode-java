package me.icro.problems.t6convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lin
 * @version v 0.1 2021/2/2
 **/
public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            int index = calcIndex(i, numRows);
            if (!map.containsKey(index)) {
                map.put(index, new ArrayList<>());
            }
            map.get(index).add(s.charAt(i));
        }
        for (int i = 0; i < numRows; i++) {
            res.append(
                    map.getOrDefault(i, new ArrayList<>()).stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining())
            );
        }
        return res.toString();
    }

    private int calcIndex(int i, int numRows) {
        if (1 == numRows) {
            return 0;
        }
        int factor = numRows + (numRows - 2);
        int remainder = i % factor;
        if (remainder < numRows) {
            return remainder;
        }
        return numRows - (remainder % numRows + 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("A", 2));
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
    }
}
