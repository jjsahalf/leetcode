package leetcode;

/**
 * Created by yufeijiang on 9/7/16.
 */
public class PaintFenceSolution {
    public int numWays(int n, int k) {
        if(n==0 || k==0){
            return 0;
        }
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }
        int[] lastOneDifferent=new int[n+1];
        int[] lastTwoSame=new int[n+1];
        lastOneDifferent[1]=k;
        lastOneDifferent[2]=k*(k-1);
        lastTwoSame[2]=k;
        for(int i=3;i<=n;i++){
            lastTwoSame[i]=lastOneDifferent[i-1];
            lastOneDifferent[i]=lastTwoSame[i-1]*(k-1)+lastOneDifferent[i-1]*(k-1);
        }
        return lastTwoSame[n]+lastOneDifferent[n];
    }
}
