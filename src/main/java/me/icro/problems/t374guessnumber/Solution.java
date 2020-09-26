package me.icro.problems.t374guessnumber;

/**
 * @author lin
 * @version v 0.1 2020/9/26
 **/
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int g = guess(mid);
            if (0 == g) {
                return mid;
            }
            if (g > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().guessNumber(10));
    }
}
