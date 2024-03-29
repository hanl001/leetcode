/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            int judge = guess(mid);
            if (judge < 0) {
                left = mid + 1;
            } else if (judge > 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        
        return left;
    }
}

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
       int l = 1;
       int r = n;
       while (l <= r) {
           int mid = (l + r) >>> 1;
           int value = guess(mid);
           if (value == 0) {
               return mid;
           } else if (value == -1) {
               r = mid - 1;
           } else {
               l = mid + 1;
           }
       }
       return -1;
    }
}
