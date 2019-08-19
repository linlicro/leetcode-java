package me.icro.topinterviewquesitons2018.sortsearch.largestnumber;

import java.util.Arrays;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/270/sort-search/1169/
 *
 * @author Lin
 * @since 2019-08-19 4:46 PM
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if (null == nums || 0 == nums.length)
            return null;
        int[] arr = Arrays.stream(nums)
                .boxed()
                .sorted((num1, num2) -> {
                    String str1 = String.valueOf(num1) + String.valueOf(num2);
                    String str2 = String.valueOf(num2) + String.valueOf(num1);
                    return Long.valueOf(str1).compareTo(Long.valueOf(str2));
                }).mapToInt(i -> i)
                .toArray();

        //StringBuilder res = new StringBuilder();
        String res = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            if ("0".equals(res)) {
                res = "";
            }
            res += String.valueOf(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[] {1, 2, 3}));
        System.out.println(new Solution().largestNumber(new int[] {11, 112, 3}));
        System.out.println(new Solution().largestNumber(new int[] {92, 923, 1}));
        System.out.println(new Solution().largestNumber(new int[] {12, 121}));
        System.out.println(new Solution().largestNumber(new int[] {0, 0}));
        System.out.println(new Solution().largestNumber(new int[] {999999998,999999997,999999999}));
    }
}
