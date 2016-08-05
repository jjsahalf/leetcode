package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 8/4/16.
 */
public class EvaluateReversePolishNotationSolution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0){
            return 0;
        }
        Stack<String> stack=new Stack();
        String operators="+-*/";

        for(String s:tokens){
            if(!operators.contains(s)){
                stack.push(s);
            }else{
                int secondNum=Integer.parseInt(stack.pop());
                int firstNum=Integer.parseInt(stack.pop());

                if(s.equals("+")){
                    stack.push(new Integer(firstNum+secondNum).toString());
                }else if(s.equals("-")){
                    stack.push(new Integer(firstNum-secondNum).toString());
                }else if(s.equals("*")){
                    stack.push(new Integer(firstNum*secondNum).toString());
                }else if(s.equals("/")){
                    stack.push(new Integer(firstNum/secondNum).toString());
                }
            }
        }
        return Integer.parseInt(stack.pop());

    }
}
