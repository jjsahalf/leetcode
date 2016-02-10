package leetcode;

/**
 * Created by yufeijiang on 2/10/16.
 */
public class PowerOfTwoSolution {

    /*
    AMAZING!!
public class Solution {
    public boolean isPowerOfTwo(int n) {
       return n > 0 && ((n & (n - 1)) == 0 );
    }
}
     */

    /*
    bit manipulation
    class Solution {
public:
    bool isPowerOfTwo(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt == 1;
    }
};
     */



    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        int power=2;
        int previousPower=1;
        int counter=1;
        while(power<n && power<=Math.sqrt(Integer.MAX_VALUE)){
            previousPower=power;
            power=power*power;
            counter=counter*2;
        }
        if(power==n){
            return true;
        }

        if(power>n){
            int checker=previousPower;
            for(int i=counter/2;i<counter;i++){
                if(checker==n){
                    return true;
                }else{
                    checker=checker*2;
                }
            }
        }

        if(power<n){
            while(power<=n){
                if(power==n){
                    return true;
                }
                if(power>(Integer.MAX_VALUE/2)){
                    return false;
                }
                power=power*2;
            }
        }

        return false;
    }
}
