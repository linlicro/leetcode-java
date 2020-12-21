package me.icro.lcof.o20isnumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/12/21
 **/
public class Solution {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>(8) {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                new HashMap<Character, Integer>(8) {{
                    put('d', 2);
                    put('.', 4);
                }},
                new HashMap<Character, Integer>(8) {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>(8) {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>(8) {{
                    put('d', 3);
                }},
                new HashMap<Character, Integer>(8) {{
                    put('s', 6);
                    put('d', 7);
                }},
                new HashMap<Character, Integer>(8) {{
                    put('d', 7);
                }},
                new HashMap<Character, Integer>(8) {{
                    put('d', 7);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>(8) {{
                    put(' ', 8);
                }}
        };

        int p = 0;
        char cur;
        for (char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                cur = 'd';
            } else if(c == '+' || c == '-') {
                cur = 's';
            } else if(c == 'e' || c == 'E') {
                cur = 'e';
            } else if(c == '.' || c == ' ') {
                cur = c;
            } else {
                cur = '?';
            }
            if(!states[p].containsKey(cur)) {
                return false;
            }
            p = (int) states[p].get(cur);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

    public static void main(String[] args) {
        new Solution().isNumber("0");
    }
}
