package leetcode;

/**
 * Created by yufeijiang on 2/4/16.
 */
public class FactorialTrailingZeroesSolution {
    public int trailingZeroes(int n) {
        if(n==0){
            return 0;
        }

        int zeroNum=0;




        while(n>=5){
            zeroNum+=n/5;
            n/=5;
        }

        return zeroNum;


    }
}
