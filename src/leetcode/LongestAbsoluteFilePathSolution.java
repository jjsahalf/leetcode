package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 10/12/16.
 */
public class LongestAbsoluteFilePathSolution {
    public int lengthLongestPath(String input) {
        if(input==null || input.length()==0){
            return 0;
        }
        int max=0;
        int counter=0;
        Stack<Integer> stack=new Stack();
        int i=0;
        boolean willFinish=false;
        while(i<input.length()){
            char curr=input.charAt(i);
            if(curr!='\n' && curr!='\t' && curr!='.'){
                counter++;
                i++;
            }
            if(curr=='.'){
                willFinish=true;
                counter++;
                i++;
            }
            if(curr=='\n'){
                if(willFinish){
                    max=Math.max(max,counter);
                }
                i++;
                willFinish=false;
                int currLevel=stack.size();
                int nextLevel=0;
                while(i<input.length()  && input.charAt(i)=='\t'  ){
                    nextLevel++;
                    i++;
                }
                if(nextLevel==currLevel+1){
                    counter++;
                    stack.push(counter);
                }
                if(nextLevel==currLevel){
                    if(stack.isEmpty()){
                        counter=0;
                    }else{
                        counter=stack.peek();
                    }
                }
                if(nextLevel<currLevel){
                    for(int j=0; j<currLevel-nextLevel; j++){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        counter=0;
                    }else{
                        counter=stack.peek();
                    }
                }
            }
        }
        //deal with the last line
        if(willFinish){
            max=Math.max(counter, max);
        }
        return max;
    }
}
