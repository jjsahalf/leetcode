package leetcode;

/**
 * Created by yufeijiang on 2/1/16.
 */
public class PathSumSolution {

    /*
    public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum (root.left, sum - root.val)
            || hasPathSum(root.right, sum - root.val);
    }
}
     */

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }

        if(root.left==null && root.right==null){
            if(root.val==sum){
                return true;
            }else{
                return false;
            }
        }

        boolean leftPath=hasPathSum(root.left, sum-root.val);
        if(leftPath){
            return true;
        }


        boolean rightPath=hasPathSum(root.right, sum-root.val);
        if(rightPath){
            return true;
        }

        return false;


    }


}
