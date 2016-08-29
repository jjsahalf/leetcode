package leetcode;

/**
 * Created by yufeijiang on 8/29/16.
 */
public class BitwiseANDOfNumbersRangeSolution {
    public int rangeBitwiseAnd(int m, int n) {
        int res;
        if(m==0){
            return 0;
        }
        int i=0;
        while(n!=m && m!=0){
            n=n>>1;
            m=m>>1;
            i++;
        }
        m=m<<i;
        return m;
    }
}
