package me.icro.problems.t1217_mincosttomovechips;

/**
 * 难点在于理解题目意思。chips = [1, 2, 2, 2, 3, 15, 23] 意味着位置1有1个筹码，位置2有3个筹码，同样位置3、15、23各有1个筹码。
 * @author lin
 * @version v 0.1 2020/3/27
 **/
public class Solution {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                even++;
            } else if (chips[i] % 2 != 0) {
                odd++;
            }
        }
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCostToMoveChips(new int[]{1, 2, 2}));
        System.out.println(new Solution().minCostToMoveChips(new int[]{1, 2, 2, 2, 2}));
    }
}
