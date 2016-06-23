package leetcode;

/**
 * Created by yufeijiang on 6/22/16.
 */
public class DecodeWaysSolution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int[] dp= new int[s.length()+1];
        dp[0]=1;
        if(s.charAt(0)>'9' || s.charAt(0)<='0'){
            return 0;
        }else{
            dp[1]=1;
        }

        for(int i=2; i<=s.length(); i++){
            StringBuffer sb=new StringBuffer();
            char currentChar=s.charAt(i-1);
            if(currentChar>'9' || currentChar<'0'){
                return 0;
            }
            if(currentChar=='0'){
                if(i-2>=0 && (s.charAt(i-2)=='1' || s.charAt(i-2)=='2')){
                    dp[i]=dp[i-2];
                    continue;
                }else{
                    return 0;
                }
            }

            if(i-2>=0 && s.charAt(i-2)=='0'){
                dp[i]=dp[i-1];
                continue;
            }

            sb.append(s.charAt(i-2));
            sb.append(s.charAt(i-1));
            int twoDigits=Integer.parseInt(sb.toString());
            if(twoDigits>=1 && twoDigits<=26){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];

    }
}
