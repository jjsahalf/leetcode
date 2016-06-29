package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yufeijiang on 6/28/16.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allList =new ArrayList();
        if(root==null){
            return allList;
        }
        Stack<TreeNode> stack=new Stack();

        int isRightBound=-1;
        List<Integer> list=new ArrayList();
        stack.add(root);
        list.add(root.val);
        allList.add(list);

        while(!stack.empty()){
            list=new ArrayList();
            Stack<TreeNode> nextStack=new Stack();
            while(!stack.empty()){
                TreeNode node=stack.pop();
                if(isRightBound==1){
                    if(node.left!=null){
                        nextStack.push(node.left);
                        list.add(node.left.val);
                    }
                    if(node.right!=null){
                        nextStack.push(node.right);
                        list.add(node.right.val);
                    }
                }else{
                    if(node.right!=null){
                        nextStack.push(node.right);
                        list.add(node.right.val);
                    }
                    if(node.left!=null){
                        nextStack.push(node.left);
                        list.add(node.left.val);
                    }
                }
            }
            isRightBound*=-1;
            stack=nextStack;
            if(list.size()!=0){
                allList.add(list);
            }

        }

        return allList;

    }
}
