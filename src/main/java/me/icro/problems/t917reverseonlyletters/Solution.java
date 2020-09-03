package me.icro.problems.t917reverseonlyletters;


/**
 * @author lin
 * @version v 0.1 2020/9/3
 **/
public class Solution {
    public String reverseOnlyLetters(String S) {
        if (null == S) {
            return S;
        }
        char[] chArr = S.toCharArray();
        int i = 0, j = chArr.length - 1;
        while (i < j) {
            if (!Character.isLetter(chArr[i])) {
                i++;
                continue;
            }
            if (!Character.isLetter(chArr[j])) {
                j--;
                continue;
            }
            char tmp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chArr);
    }
}
