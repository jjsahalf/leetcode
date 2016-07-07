package leetcode;

import java.util.List;

/**
 * Created by yufeijiang on 7/6/16.
 */
public class TriangleSolution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0){
            return 0;
        }
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }

        int n=triangle.size();

        int dp[]=new int[n];

        for(int i=0; i<n; i++){
            dp[i]=triangle.get(n-1).get(i);
        }

        for(int i=n-2; i>=0;i--){
            for(int j=0; j<triangle.get(i).size();j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }

        return dp[0];

    }
}
