package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 10/22/16.
 */
public class BasicCalculatorIISolution {
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        char sign='+';
        int number=0;
        Stack<Integer> stack=new Stack();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(Character.isDigit(curr)){
                number=number*10+curr-'0';
            }
            if("+-*/".contains(String.valueOf(curr))){
                if(sign=='+'){
                    stack.push(number);
                }
                if(sign=='-'){
                    stack.push(-number);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*number);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/number);
                }
                sign=curr;
                number=0;
            }
        }
        if(sign=='+'){
            stack.push(number);
        }
        if(sign=='-'){
            stack.push(-number);
        }
        if(sign=='*'){
            stack.push(stack.pop()*number);
        }
        if(sign=='/'){
            stack.push(stack.pop()/number);
        }
        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
