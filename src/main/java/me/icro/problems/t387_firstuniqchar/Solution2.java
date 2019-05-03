package me.icro.problems.t387_firstuniqchar;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-03 11:46 AM
 */
public class Solution2 {
    public int firstUniqChar(String s) {

        /**
         * Since we can assume only lowercase letters.
         * Using a fixed array instead of a HashMap is a lot faster.
         */
        int[] count = new int[26];
        int n = s.length();

        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }

        }

        return -1;
    }
}
