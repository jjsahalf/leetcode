package leetcode;

/**
 * Created by yufeijiang on 8/31/16.
 */
public class ValidateBinarySearchTreeSolution {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    public boolean helper(TreeNode root, double min, double max){
        if(root==null){
            return true;
        }
        if(root.val>min && root.val<max){
            return helper(root.left,min, root.val) && helper(root.right, root.val, max);
        }else{
            return false;
        }
    }
}
