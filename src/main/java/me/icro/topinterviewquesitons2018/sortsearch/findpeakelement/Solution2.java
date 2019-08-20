package me.icro.topinterviewquesitons2018.sortsearch.findpeakelement;

/**
 * 描述:
 *
 * 二分法 时间复杂度 : O(log_2(n))
 *
 * @author Lin
 * @since 2019-08-20 5:32 PM
 */
public class Solution2 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findPeakElement(new int[] {1,2,3,1}));
        System.out.println(new Solution2().findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }
}
