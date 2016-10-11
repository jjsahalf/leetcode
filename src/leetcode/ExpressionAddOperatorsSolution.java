package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 10/10/16.
 */
public class ExpressionAddOperatorsSolution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList();
        if(num==null || num.equals("")){
            return list;
        }
        helper(num, target, "", 0, 0, list);
        return list;
    }
    public void helper(String num, int target, String temp, long currRes,long prevNum, List<String> list){
        if(currRes==target && num.length()==0){
            String resStr=new String(temp);
            list.add(resStr);
            return;
        }
        for(int i=1; i<=num.length();i++){
            String currStr=num.substring(0,i);
            if(currStr.length()>1 && currStr.charAt(0)=='0'){
                return;
            }
            long currNum=Long.parseLong(currStr);
            String next=num.substring(i);
            if(temp.length()!=0){

                helper(next, target, temp+"+"+currStr, currRes+currNum, currNum, list);
                helper(next, target, temp+"-"+currStr, currRes-currNum, -currNum, list);
                helper(next, target, temp+"*"+currStr, currRes-prevNum+prevNum*currNum, prevNum*currNum, list);
            }else{
                helper(next, target, currStr, currNum, currNum, list);
            }
        }
    }
}
