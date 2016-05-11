package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 5/11/16.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String result=new String();

        if(path==null){
            return result;
        }
        if(path.equals("")){
            return result;
        }

        String[] array=path.split("/");
        Stack<String> stack=new Stack();
        for(int i=0;i<array.length;i++){
            if(array[i].equals("")){
                continue;
            }
            if(array[i].equals(".")){
                continue;
            }
            if(array[i].equals("..")){
                if(stack.empty()){
                    continue;
                }else{
                    stack.pop();
                    continue;
                }
            }
            stack.push(array[i]);
        }


        if(stack.size()==0){
            return "/";
        }

        Stack<String> stack2=new Stack();
        while(!stack.empty()){
            stack2.push(stack.pop());
        }

        StringBuffer sb=new StringBuffer();

        while(!stack2.empty()){
            sb.append("/");
            sb.append(stack2.pop());
        }


        return sb.toString();

    }
}
