package me.icro.lcof.o44findnthdigit;

/**
 * @author lin
 * @version v 0.1 2020/12/29
 **/
public class Solution {
    public int findNthDigit(int n) {
        if (0 == n) {
            return 0;
        }

        // 数位（个位/十位/百位/...，就是1/2/3/...
        int digit = 1;
        // 属于该数位的所有数的起始点数（个位是1，十位是10，百位是100）
        long start = 1;
        // 该数位的数一共的索引个数（不是数字个数）
        long count = digit * 9 * start;

        while (n > count) {
            n -=count;
            digit++;
            start *= 10;
            count = digit * 9 * start;
        }

        // 算出原始的 n 到底对应哪个数字
        long num = start + (n - 1) / digit;
        // 余数就是原始的 n 是这个数字中的第几位
        int remainder = (n - 1) % digit;

        String numStr = String.valueOf(num);
        return numStr.charAt(remainder) - '0';
    }
}
