package leetcode;

class Result{
    boolean isBST;
    int nodeNum;
    double min;
    double max;
    Result(boolean isBST, int nodeNum, double min, double max){
        this.isBST=isBST;
        this.nodeNum=nodeNum;
        this.min=min;
        this.max=max;
    }
}
/**
 * Created by yufeijiang on 8/31/16.
 */
public class LargestBSTSubtreeSolution {
    public int largestBSTSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Result res=helper(root);
        return res.nodeNum;
    }
    public Result helper(TreeNode root){
        if(root==null){
            return new Result(true, 0, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        }
        Result left=helper(root.left);
        Result right=helper(root.right);
        if(left.isBST && right.isBST && root.val>left.max && root.val<right.min){
            return new Result(true, left.nodeNum+right.nodeNum+1, Math.min(root.val, left.min), Math.max(root.val, right.max));
        }else{
            return new Result(false, Math.max(left.nodeNum, right.nodeNum),0, 0);
        }
    }
}
