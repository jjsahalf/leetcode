package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yufeijiang on 11/7/16.
 */
public class RussianDollEnvelopesSolution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0 || envelopes[0].length==0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        int[] dp=new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max=1;
        for(int i=0; i<envelopes.length; i++){
            for(int j=0; j<i; j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}
