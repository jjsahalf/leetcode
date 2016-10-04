package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 10/3/16.
 */
public class RemoveKDigits {

    /*
    dp会超时,侧面说明应该pass了其他的要求
        public String removeKdigits(String num, int k) {
        if(num==null || num.length()==0){
            return "";
        }
        if(k<=0){
            return num;
        }
        if(k>=num.length()){
            return "0";
        }
        String[][] dp=new String[num.length()+1][k+1];
        dp[0][0]="0";
        for(int i=1;i<=num.length();i++){
            dp[i][0]=num.substring(0,i);
        }
        for(int j=1;j<=k;j++){
            dp[0][j]="0";
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(i<=j){
                    dp[i][j]="0";
                }else{
                    String case1=dp[i-1][j]+num.charAt(i-1);
                    String case2=dp[i-1][j-1];
                    int num1=Integer.parseInt(case1);
                    int num2=Integer.parseInt(case2);
                    if(num1<num2){
                        dp[i][j]=case1;
                    }else{
                        dp[i][j]=case2;
                    }
                }
            }
        }
        Integer res=Integer.parseInt(dp[num.length()][k]);
        return res.toString();

    }
     */
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        if (num.length() == 0 || num.length() <= k){
            return "0";
        }
        int counter=k;
        for(int i=0;i<num.length();i++){
            char curr=num.charAt(i);
            while(!stack.isEmpty() && counter>0 && curr<stack.peek()){
                stack.pop();
                counter--;
            }
            stack.push(curr);
        }
        Stack<Character> reverseStack=new Stack();
        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<num.length()-k;i++){
            sb.append(reverseStack.pop());
        }

        return removeLeadingZero(sb.toString());
    }
    public String removeLeadingZero(String str){
        if(str==null || str.equals("")){
            return "0";
        }
        if(str.charAt(0)=='0'){
            return removeLeadingZero(str.substring(1));
        }else{
            return str;
        }
    }


}
