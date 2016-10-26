package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yufeijiang on 10/26/16.
 */
public class BasicCalculatorSolution {
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        s=s.replace(" ","");
        Stack<String> stack=new Stack();
        int i=0;
        List<String> list=new ArrayList();
        while(i<s.length()){
            if(s.charAt(i)=='+' || s.charAt(i)=='-'){
                if(stack.isEmpty() || stack.peek().equals("(")){
                    stack.push(String.valueOf(s.charAt(i)));
                    i++;
                }else{
                    String op=stack.pop();
                    list.add(op);
                }
                continue;
            }
            if(s.charAt(i)=='('){
                stack.push(String.valueOf(s.charAt(i)));
                i++;
                continue;
            }
            if(s.charAt(i)==')'){
                if(!stack.peek().equals("(")){
                    String op=stack.pop();
                    list.add(op);
                }else{
                    stack.pop();
                    i++;
                }
                continue;
            }
            StringBuffer sb=new StringBuffer();
            while(i<s.length() && Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
                i++;
            }
            list.add(sb.toString());
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Stack<Integer> oprandStack=new Stack();
        for(String str:list){
            if(str.equals("+") || str.equals("-")){
                int oprand2=oprandStack.pop();
                int oprand1=oprandStack.pop();
                if(str.equals("+")){
                    oprandStack.push(oprand1+oprand2);
                }
                if(str.equals("-")){
                    oprandStack.push(oprand1-oprand2);
                }
            }else{
                oprandStack.push(Integer.parseInt(str));
            }
        }
        return oprandStack.pop();
    }
}
