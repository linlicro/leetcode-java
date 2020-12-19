package me.icro.lcof.o05replacespace;

/**
 * @author lin
 * @version v 0.1 2020/12/19
 **/
public class Solution {
    public String replaceSpace(String s) {
//        return s.replaceAll(" ", "%20");
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
