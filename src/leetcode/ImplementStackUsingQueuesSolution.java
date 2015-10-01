package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yufeijiang on 10/1/15.
 */
public class ImplementStackUsingQueuesSolution {
    private Queue<Integer> emptyQueue=new LinkedList();
    private Queue<Integer> stackQueue=new LinkedList();

    // Push element x onto stack.
    public void push(int x) {
        emptyQueue.offer(x);
        while(!stackQueue.isEmpty()){
            emptyQueue.offer(stackQueue.poll());
        }
        Queue tempQueue=emptyQueue;
        emptyQueue=stackQueue;
        stackQueue=tempQueue;
    }

    // Removes the element on top of the stack.
    public void pop() {
        stackQueue.poll();
    }

    // Get the top element.
    public int top() {
        return stackQueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stackQueue.isEmpty();
    }
}
