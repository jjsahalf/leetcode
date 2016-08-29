package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 8/29/16.
 */
public class VerifyPreorderSerializationOfABinaryTreeSolution {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length()==0){
            return false;
        }
        String[] array=preorder.split(",");

        Stack<String> stack=new Stack();
        for(String current:array){
            if(!current.equals("#")){
                stack.push(current);
            }else{
                if(stack.isEmpty()){
                    stack.push(current);
                }else{
                    while((!stack.isEmpty()) && stack.peek().equals("#")){
                        stack.pop();
                        if(!stack.isEmpty()){
                            stack.pop();
                        }else{
                            return false;
                        }

                    }
                    stack.push(current);
                }
            }
        }
        if((!stack.isEmpty()) && stack.size()==1 && stack.peek().equals("#")){
            return true;
        }else{
            return false;
        }
    }
}
