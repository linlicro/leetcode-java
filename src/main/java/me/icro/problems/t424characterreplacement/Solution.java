package me.icro.problems.t424characterreplacement;

/**
 * @author lin
 * @version v 0.1 2020/11/24
 **/
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] charArr = new int[26];
        int maxCount = 0, left = 0, right = 0, res = 0;

        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            charArr[index]++;
            maxCount = Math.max(maxCount, charArr[index]);

            if (right - left + 1 - maxCount > k) {
                charArr[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
