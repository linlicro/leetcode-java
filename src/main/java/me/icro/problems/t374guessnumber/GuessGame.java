package me.icro.problems.t374guessnumber;

/**
 * @author lin
 * @version v 0.1 2020/9/26
 **/
public class GuessGame {

    private int peed = 6;

    /**
     * Forward declaration of guess API.
     * @param num your guess
     * @return -1 if num is lower than the guess number
     *          1 if num is higher than the guess number
     *          otherwise return 0
     */
    int guess(int num) {
        if (num > peed) {
            return 1;
        } else if (num < peed) {
            return -1;
        }
        return 0;
    }
}
