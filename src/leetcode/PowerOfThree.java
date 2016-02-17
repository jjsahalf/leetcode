package leetcode;

/**
 * Created by yufeijiang on 2/17/16.
 */
public class PowerOfThree {

    /*
    This solution is Bravo!!!!
     */

    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }else{
            Integer integer=n;
            return integer.toString(n,3).matches("10*");
        }
    }
}
