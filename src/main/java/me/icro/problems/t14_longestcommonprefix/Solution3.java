package me.icro.problems.t14_longestcommonprefix;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-04-02 9:52 AM
 */
public class Solution3 { // Divide and conquer

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r)
            return strs[l];
        else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Solution3().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(new Solution3().longestCommonPrefix(new String[]{"dog", ""}));
        System.out.println(new Solution3().longestCommonPrefix(new String[]{"aa", "a"}));
    }

}
