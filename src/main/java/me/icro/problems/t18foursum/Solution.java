package me.icro.problems.t18foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/11/19
 **/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, len, target, 4, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int len, int target, int k, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (index >= len) {
            return res;
        }
        if (2 == k) {
            // 2Sum
            int left = index, right = len - 1;
            while (left < right) {
                // gotit
                if (target - nums[left] == nums[right]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    // skip
                    while (left < right && nums[left] == nums[++left]) {
                    }
                    while (left < right && nums[right] == nums[--right]) {
                    }
                } else if (target - nums[left] > nums[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            // 递归入 k-1 sum
            for (int i = index; i < len - k + 1; i++) {
                List<List<Integer>> tempList = kSum(nums, len, target - nums[i], k - 1, i + 1);
                for (List<Integer> list : tempList) {
                    list.add(0, nums[i]);
                }
                res.addAll(tempList);
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
