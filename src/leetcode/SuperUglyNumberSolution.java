package leetcode;

/**
 * Created by yufeijiang on 11/8/16.
 */
public class SuperUglyNumberSolution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly=new int[n];
        int[] factor=new int[primes.length];
        ugly[0]=1;
        for(int i=1; i<n;i++){
            ugly[i]=Integer.MAX_VALUE;
            for(int j=0; j<factor.length; j++){
                ugly[i]=Math.min(ugly[i], ugly[factor[j]]*primes[j]);
            }
            for(int j=0; j<factor.length;j++){
                if(ugly[i]==ugly[factor[j]]*primes[j]){
                    factor[j]++;
                }
            }
        }
        return ugly[n-1];
    }
}
