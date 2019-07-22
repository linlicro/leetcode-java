package me.icro.topinterviewquesitons2018.heapstackqueue.evalrpn;

import java.util.Stack;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/266/heap-stack-queue/1161/
 *
 * @author Lin
 * @since 2019-07-22 11:10 AM
 */
public class Solution {
    public int evalRPN(String[] tokens) {

        if (null == tokens || 0 == tokens.length)
            return 0;

        Stack stack = new Stack();
        for(int i=0;i<tokens.length;i++){
            String tokeni = tokens[i];
            if(tokeni.equals("+") || tokeni.equals("-") || tokeni.equals("*") || tokeni.equals("/")){
                int v1 = (Integer) stack.pop();
                int v2 = (Integer) stack.pop();
                if(tokeni.equals("+")){
                    stack.push(v2+v1);
                }
                if(tokeni.equals("-")){
                    stack.push(v2-v1);
                }
                if(tokeni.equals("*")){
                    stack.push(v2*v1);
                }
                if(tokeni.equals("/")){
                    int res = v2/v1;
                    stack.push(res);
                }
            }else{
                stack.push(Integer.parseInt(tokeni));
            }
        }
        return (Integer) stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(new Solution().evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(new Solution().evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
