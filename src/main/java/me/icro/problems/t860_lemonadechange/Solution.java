package me.icro.problems.t860_lemonadechange;

/**
 * @author lin
 * @version v 0.1 2020/3/26
 **/
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarCount = 0;
        int tenDollarCount = 0;
        for (int bill : bills) {
            if (5 == bill) {
                fiveDollarCount++;
                continue;
            }
            if (10 == bill) {
                if (0 == fiveDollarCount) {
                    return false;
                }
                tenDollarCount++;
                fiveDollarCount--;
            }
            if (20 == bill) {
                if (0 < tenDollarCount && 0 < fiveDollarCount) {
                    tenDollarCount--;
                    fiveDollarCount--;
                    continue;
                }
                if (0 == tenDollarCount && 3 < fiveDollarCount) {
                    fiveDollarCount -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 10}));
        System.out.println(new Solution().lemonadeChange(new int[]{10, 10}));
    }
}
