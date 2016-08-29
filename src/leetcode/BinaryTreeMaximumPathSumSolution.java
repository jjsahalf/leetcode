package leetcode;

/**
 * Created by yufeijiang on 8/28/16.
 */
public class BinaryTreeMaximumPathSumSolution {
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        ReturnType rt=helper(root);
        return rt.maxSum;
    }

    public ReturnType helper(TreeNode root){
        if(root==null){
            return new ReturnType(Integer.MIN_VALUE,0);
        }
        ReturnType rtLeft;
        ReturnType rtRight;
        rtLeft=helper(root.left);
        rtRight=helper(root.right);
        int currentMaxSum=Math.max(rtLeft.singlePath, 0) + root.val+ Math.max(rtRight.singlePath, 0);
        int maxSum=Math.max(Math.max(rtLeft.maxSum, rtRight.maxSum), currentMaxSum);
        int singlePath= Math.max(Math.max(rtLeft.singlePath+root.val, root.val), rtRight.singlePath+root.val);
        return new ReturnType(maxSum, singlePath);
    }
}

class ReturnType{
    public int maxSum;
    public int singlePath;
    public ReturnType(int ms, int sp){
        maxSum=ms;
        singlePath=sp;
    }
}
