package me.icro.problems.t338countbits;

/**
 * dp:
 * 1. 当数字为 奇数，1的数量一定比前面那个偶数过一个1
 * 2. 当数字为 偶数，1的个数一定和除以2的那个数一样多
 *
 * @author lin
 * @version v 0.1 2020/8/7
 **/
public class Solution2 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (1 == i % 2) {
                result[i] = result[i / 2] + 1;
            } else {
                result[i] = result[i / 2];
            }
        }
        return result;
    }
}
