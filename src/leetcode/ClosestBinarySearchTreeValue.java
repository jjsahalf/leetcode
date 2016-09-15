package leetcode;

/**
 * Created by yufeijiang on 9/15/16.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(target==root.val){
            return root.val;
        }
        int subTreeClosest=0;
        if(target>root.val){
            subTreeClosest = closestValue(root.right, target);
        }
        if(target<root.val){
            subTreeClosest = closestValue(root.left, target);
        }
        if(subTreeClosest==Integer.MAX_VALUE){
            return root.val;
        }else{
            return Math.abs(target-root.val)<=Math.abs(target-subTreeClosest)?root.val:subTreeClosest;
        }
    }
}
