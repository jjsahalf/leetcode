package leetcode;

/**
 * Created by yufeijiang on 2/5/16.
 */
public class ReverseBitsSolution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int reverse=0;
        for(int i=0;i<32;i++){
            int theLastBit=n&1;
            reverse=reverse<<1;
            n=n>>>1;
            reverse=reverse | theLastBit;

        }

        return reverse;
    }
}
