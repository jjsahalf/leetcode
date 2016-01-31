package leetcode;

/**
 * Created by yufeijiang on 1/31/16.
 */
public class BalancedBinaryTreeSolution {


    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        int leftDepth=findDepth(root.left);
        int rightDepth=findDepth(root.right);

        if(Math.abs(leftDepth-rightDepth)<=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }else{
            return false;
        }

    }

    int findDepth(TreeNode node){

        if(node==null){
            return 0;
        }

        if(node.left==null && node.right==null){
            return 1;
        }

        int left=findDepth(node.left);
        int right=findDepth(node.right);

        if(left>=right){
            return left+1;
        }else{
            return right+1;
        }


    }





}
