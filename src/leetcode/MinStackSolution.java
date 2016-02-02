package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 2/2/16.
 */
public class MinStackSolution {

    private Stack<Integer> stack=new Stack();
    private Stack<Integer> minStack=new Stack();

    public void MinStack(){
        stack=new Stack();
        minStack=new Stack();
    }


    public void push(int x) {
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }else{
            int currentMin=minStack.peek();
            if(x<=currentMin){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int goneNumber=stack.pop();
        if(goneNumber==minStack.peek()){
            minStack.pop();
        }
        if(minStack.empty() && !stack.empty()){
            minStack.push(stack.peek());
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
