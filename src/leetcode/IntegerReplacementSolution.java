package leetcode;

/**
 * Created by yufeijiang on 11/6/16.
 */
public class IntegerReplacementSolution {
    public int integerReplacement(int n) {
        return (int)longReplacement(n);
    }
    public long longReplacement(long n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n%2==0){
            return longReplacement(n/2)+1;
        }else{
            return Math.min(longReplacement(n+1)+1, longReplacement(n-1)+1);
        }
    }
}
