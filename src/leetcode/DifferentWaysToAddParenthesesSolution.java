package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 9/1/16.
 */
public class DifferentWaysToAddParenthesesSolution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        String opt = "+-*";
        for(int i = 0; i < input.length(); i++) {
            if(opt.contains(""+input.charAt(i))){
                String left = input.substring(0,i);
                String right = input.substring(i+1);
                List<Integer> leftList = diffWaysToCompute(left);
                List<Integer> rightList = diffWaysToCompute(right);
                for(Integer l : leftList) {
                    for(Integer r : rightList) {
                        if(input.charAt(i) == '+'){
                            res.add(l+r);
                        }else if(input.charAt(i) == '-'){
                            res.add(l-r);
                        }else if(input.charAt(i) == '*'){
                            res.add(l*r);
                        }else{
                            res.add(0);
                        }
                    }
                }
            }
        }
        if(res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
