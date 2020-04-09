package me.icro.leetcodingchallenge2004.backspacecompare;

/**
 * @author lin
 * @version v 0.1 2020/4/9
 **/
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sum = 0;
        int count = 0;
        for (int length = S.length(); length > 0; length--) {
            if (S.charAt(length - 1) == '#') {
                count++;
                continue;
            }
            if (count > 0) {
                count--;
                continue;
            }
            sum += S.charAt(length - 1) - 'a' + 1;
        }
        count = 0;
        for (int length = T.length(); length > 0; length--) {
            if (T.charAt(length - 1) == '#') {
                count++;
                continue;
            }
            if (count > 0) {
                count--;
                continue;
            }
            sum -= T.charAt(length - 1) - 'a' + 1;
        }
        return 0 == sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new Solution().backspaceCompare("a##c", "#a#c"));
        System.out.println(new Solution().backspaceCompare("a#c", "b"));
        System.out.println(new Solution().backspaceCompare("ab##", "c#d#"));
//        "mdamdluynq###########epymatjzksas"
//        "mdamdluynq###########epymatjzkss"
        System.out.println(new Solution().backspaceCompare("mdamdluynq###########m#epymatjzksasf#", "mdamdluynq###########m#epymatjzksa#sf#"));
    }
}
