package me.icro.problems.t17lettercombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/6/9
 **/
public class Solution {
    Map<Character, String[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        //init map
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        List<String> res = new ArrayList<>();
        if (null == digits || 0 == digits.length()) {
            return res;
        }
        dfs(digits.toCharArray(), 0, "", res);
        return res;
    }

    private void dfs(char[] charArray, int level, String cur, List<String> res) {
        if (level == charArray.length) {
            res.add(cur);
            return;
        }
        String[] strings = map.get(charArray[level]);
        for (String string : strings) {
            dfs(charArray, level + 1, cur + string, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
