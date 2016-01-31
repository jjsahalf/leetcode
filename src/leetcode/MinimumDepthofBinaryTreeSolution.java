package leetcode;

/**
 * Created by yufeijiang on 1/31/16.
 */
public class MinimumDepthofBinaryTreeSolution {

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }


        if(root.left==null && root.right==null){
            return 1;
        }

        int leftMinDepth=minDepth(root.left);
        int rightMinDepth=minDepth(root.right);


        if(leftMinDepth==0){
            return rightMinDepth+1;
        }

        if(rightMinDepth==0){
            return leftMinDepth+1;
        }


        if(leftMinDepth<=rightMinDepth){
            return leftMinDepth+1;
        }else{
            return rightMinDepth+1;
        }


    }
}
