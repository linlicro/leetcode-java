package me.icro.topinterviewquesitons2018.string.partition;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/275/string/1137/
 * <p>
 * 思路: 回溯算法 - DFS（深度优先搜索）或者BFS（广度优先搜索）
 * <p>
 * step 1. 分割为 a + ac
 * step 2. 分割为 a + a + c, 得到一组结果，回溯至 a + ac
 * step 3. a + ac中 ac不是回文，继续回溯 至 aac
 * step 4. 分割长度稍长的 aa + c, 得到一组结果，再回溯至 aac
 * step 5. aac不是回文，搜索结束
 *
 * @author Lin
 * @since 2019-07-30 10:31 AM
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (null == s || 0 == s.length())
            return res;

        dfs(s, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> remain, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(remain));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindroom(s, start, end)) {
                remain.add(s.substring(start, end + 1));
                dfs(s, res, remain, end + 1); // 从 end + 1 开始递归，寻找回文串
                remain.remove(remain.size() - 1); // 回溯
            }
        }
    }

    private boolean isPalindroom(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindroom("abba", 0, 3));
    }
}
