package me.icro.topinterviewquesitons2018.sortsearch.findduplicate;

/**
 * 描述:
 * <p>
 * 分析:
 * <p>
 * 0. 注意前提条件 - 包含n+1个整数，数字都在1到n之间 包括1和n，也就是说有n个菠萝坑，要放n+1个萝卜，总有一个坑是有两个萝卜: )
 * 1. 二分法，对n(数值)做二分; 遍历整个数组，统计小于( (n + 1) / 2)的个数，个数超过 n / 2个，说明重复数值在[1, mid); 否则 在[mid, n].
 * 2. 以 [1, 2, 2, 3, 4, 5, 6, 7] 为例，一共有 8个数, mid = 4, 遍历数组，小于mid的个数是4, 即 result在[1, 4)中, 下一个mid = 2, 一次类推，知道变成1个整数.
 *
 * 时间复杂度：O(N \log N)O(NlogN)，二分法的时间复杂度为 O(\log N)O(logN)，在二分法的内部，执行了一次 for 循环，时间复杂度为 O(N)O(N)，故时间复杂度为 O(N \log N)O(NlogN)。
 * <p>
 * 备注: why to use >>> operator?
 * A: The >>> operator is the unsigned right bit-shift operator in Java. It effectively divides the operand by  2 to the power of the right operand, or just 2 here.
 *
 * @author Lin
 * @since 2019-08-28 3:23 PM
 */
public class Solution2 {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findDuplicate(new int[]{1, 2, 2, 3, 4, 5, 6, 7}));
    }
}
