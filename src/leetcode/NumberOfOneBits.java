package leetcode;

/**
 * Created by yufeijiang on 2/5/16.
 */
public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum=0;
        for(int i=0;i<32;i++){
            sum+=n & 1;
            n=n>>>1;
        }
        return sum;
    }
}
