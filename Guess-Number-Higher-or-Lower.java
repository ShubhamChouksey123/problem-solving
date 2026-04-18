1/** 
2 * Forward declaration of guess API.
3 * @param  num   your guess
4 * @return 	     -1 if num is higher than the picked number
5 *			      1 if num is lower than the picked number
6 *               otherwise return 0
7 * int guess(int num);
8 */
9
10public class Solution extends GuessGame {
11    public int guessNumber(int n) {
12        return guessNumber(0, n);
13    }
14
15    public int guessNumber(int start, int end) {
16
17        if(start == end)
18            return start;
19
20        int mid = start + (end - start)/2;
21        int possiblity = guess(mid);
22        if(possiblity == 0){
23            return mid;
24        }
25        else if(possiblity == -1){
26            return guessNumber(0, mid - 1);
27        }
28        return guessNumber(mid + 1, end);
29    }
30}