package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 10/10/16.
 */
public class RemoveInvalidParenthesesSolution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList();
        if(s==null){
            return res;
        }
        Set<String> visited=new HashSet();
        Queue<String> queue=new LinkedList();
        queue.offer(s);
        visited.add(s);
        boolean isFound=false;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String curr=queue.poll();
                if(isValid(curr)){
                    isFound=true;
                    res.add(curr);
                }
                if(!isFound){
                    for(int j=0;j<curr.length();j++){
                        String temp=curr.substring(0, j)+curr.substring(j+1);
                        if(!visited.contains(temp)){
                            visited.add(temp);
                            queue.offer(temp);
                        }
                    }
                }
            }
            if(isFound){
                break;
            }
        }
        return res;
    }

    public boolean isValid(String str){
        Stack<Character> stack=new Stack();
        for(int i=0; i<str.length();i++){
            char curr=str.charAt(i);
            if(curr=='('){
                stack.push(curr);
            }
            if(curr==')'){
                if(stack.isEmpty()){
                    return false;
                }else if(stack.peek()!='('){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.size()==0;
    }
}
