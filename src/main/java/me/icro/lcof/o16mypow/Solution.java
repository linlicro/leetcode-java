package me.icro.lcof.o16mypow;

/**
 * @author lin
 * @version v 0.1 2020/12/21
 **/
public class Solution {
        public double myPow(double x, int n) {
            if (0.0f == x) {
                return 0.0d;
            }
            double res = 1.0;
            long b = n;
            // 当 n<0 时：把问题转化至 n≥0 的范围内，即执行 x = 1/x，n = -n。
            if (b < 0) {
                x = 1 / x;
                b = -b;
            }
            while (b > 0) {
                if ((b & 1) == 1) {
                    // 是奇数
                    res *= x;
                }
                x *= x;
                b >>= 1;
            }
            return res;
        }
}
