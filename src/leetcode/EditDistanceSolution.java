package leetcode;

/**
 * Created by yufeijiang on 8/15/16.
 */
public class EditDistanceSolution {
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];


        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=j;
        }
        int i=1;
        int j=1;

        for(i=1; i<=len1;i++){
            char c1=word1.charAt(i-1);
            for(j=1;j<=len2;j++){
                if(word2.charAt(j-1)==c1){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int replace=dp[i-1][j-1]+1;
                    int insert=dp[i][j-1]+1;
                    int delete=dp[i-1][j]+1;
                    int min=Math.min(replace,insert);
                    min=Math.min(min,delete);
                    dp[i][j]=min;
                }
            }
        }
        return dp[len1][len2];
    }
}
