package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 8/19/16.
 */
public class InorderSuccessorInBSTSolution {
    private Stack<TreeNode> stack=new Stack();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        while(hasNext()){
            TreeNode curr=getNext();
            if(curr==p){
                if(hasNext()){
                    return getNext();
                }else{
                    return null;
                }
            }
        }
        return null;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public TreeNode getNext(){
        TreeNode res=stack.pop();
        TreeNode temp=res;
        if(temp.right!=null){
            temp=temp.right;
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
        }
        return res;
    }
}
