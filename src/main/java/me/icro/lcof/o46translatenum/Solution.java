package me.icro.lcof.o46translatenum;

/**
 * @author lin
 * @version v 0.1 2020/12/29
 **/
public class Solution {

    int res = 0;

    public int translateNum(int num) {
        if (0 == num) {
            return 1;
        }
        int l2 = num % 100;
        return translateNum(num / 10) + (l2 >= 10 && l2 <= 25 ? translateNum(num / 100) : 0);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(0));
        System.out.println(new Solution().translateNum(10));
        System.out.println(new Solution().translateNum(12258));
    }
}
