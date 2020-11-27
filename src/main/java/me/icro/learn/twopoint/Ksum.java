package me.icro.learn.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/11/27
 **/
public class Ksum {
    /**
     * Find all k elements groups that adding up to given target.
     *
     * @param nums   input array
     * @param k      k
     * @param target target value
     * @return all groups
     */
    public List<List<Integer>> kSum(int[] nums, int k, int target) {
        Arrays.sort(nums);
        if (k <= 1) {
            List<List<Integer>> res = new ArrayList<>();
            if (k == 1 && Arrays.binarySearch(nums, target) >= 0) {
                res.add(Collections.singletonList(target));
            }
            return res;
        }
        return kSum(nums, k, target, 0);
    }

    /**
     * Helper function for K-sum.
     *
     * @param nums     input array
     * @param k        k
     * @param target   target value
     * @param beginIdx begin index
     * @return all groups of k elements from beginIdx that adding up to target.
     */
    private List<List<Integer>> kSum(int[] nums, int k, int target, int beginIdx) {
        int len = nums.length;
        if (k == 2) {
            List<List<Integer>> res = new ArrayList<>();
            int left = beginIdx, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    ++left;
                    --right;
                } else if (sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
            return res;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = beginIdx; i <= len - k; i++) {
            if (i > beginIdx && nums[i] == nums[i - 1] || nums[i] + (k - 1) * nums[len - 1] < target) {
                continue;
            }
            if (nums[i] + (k - 1) * nums[i + 1] > target) {
                break;
            }
            List<List<Integer>> sub = kSum(nums, k - 1, target - nums[i], i + 1);
            for (List<Integer> list : sub) {
                list.add(0, nums[i]);
            }
            res.addAll(sub);
        }
        return res;
    }
}
