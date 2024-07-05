/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    
    public int guessNumberUtil(long start, long end) {
        
        long mid = (start + end)/2;
        int side = guess((int)mid);
        if(side == 0){
            return (int)mid;
        }
        if(side > 0){
            return guessNumberUtil(mid + 1, end);
        }
        return guessNumberUtil(start, mid - 1);
    }
    
    public int guessNumber(int n) {
        
        return guessNumberUtil(1l, (long)n);
    }
}