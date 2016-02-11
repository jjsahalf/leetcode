package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 2/11/16.
 */
public class ImplementQueueUsingStacksSolution {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public ImplementQueueUsingStacksSolution(){
        stack1=new Stack();
        stack2=new Stack();
    }


    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stack2.empty()){
            stack2.pop();
        }else{
            while(!stack1.empty()){
                int popNumber=stack1.pop();
                stack2.push(popNumber);
            }
            stack2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!stack2.empty()){
            return stack2.peek();
        }else{
            while(!stack1.empty()){
                int popNumber=stack1.pop();
                stack2.push(popNumber);
            }
            return stack2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(stack1.empty() && stack2.empty()){
            return true;
        }else{
            return false;
        }
    }
}
