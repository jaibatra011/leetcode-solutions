/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start=0, end=n, num=0,guess=-1;
        while(guess!=0 && end>start){
            num=start+(end-start)/2;
            guess=guess(num);
            if(guess<0)
                end=num-1;
            else
                start=num+1;
        }
        if(guess!=0 && end==start)
            return start;
        return num;
    }
}