package me.icro.problems.t22_generateparenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路:
 *  递归求解
 *  括号合法性验证:
 *      1. 左括号的数量 小于等于 n
 *      2. 右括号的数量 小于等于左括号
 * @author lin
 * @version v 0.1 2020/5/29
 **/
public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }

    private void generate(int leftCount, int rightCount, int n, String string, List<String> res) {
        if (n == leftCount && n == rightCount) {
            res.add(string);
            return;
        }

        if (leftCount < n) {
            generate(leftCount + 1, rightCount, n, string + "(", res);
        }
        if (rightCount < leftCount) {
            generate(leftCount, rightCount + 1, n, string + ")", res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
