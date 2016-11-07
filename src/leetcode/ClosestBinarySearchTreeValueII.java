package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yufeijiang on 11/7/16.
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list=new ArrayList();
        if(root==null){
            return list;
        }
        Stack<Integer> stack=new Stack();
        Stack<Integer> reverseStack=new Stack();
        inOrder(root, stack, target);
        reverseInOrder(root, reverseStack, target);
        for(int i=0; i<k; i++){
            if(stack.size()==0){
                list.add(reverseStack.pop());
            }else if(reverseStack.size()==0){
                list.add(stack.pop());
            }else if(Math.abs(stack.peek()-target)<Math.abs(reverseStack.peek()-target)){
                list.add(stack.pop());
            }else{
                list.add(reverseStack.pop());
            }
        }
        return list;
    }

    private void inOrder(TreeNode root, Stack<Integer> stack, double target){
        if(root==null){
            return;
        }
        inOrder(root.left, stack, target);
        if(root.val>target){
            return;
        }else{
            stack.push(root.val);
        }
        inOrder(root.right, stack, target);
    }

    private void reverseInOrder(TreeNode root, Stack<Integer> stack, double target){
        if(root==null){
            return;
        }
        reverseInOrder(root.right, stack, target);
        if(root.val<=target){
            return;
        }else{
            stack.push(root.val);
        }
        reverseInOrder(root.left, stack, target);
    }
}
