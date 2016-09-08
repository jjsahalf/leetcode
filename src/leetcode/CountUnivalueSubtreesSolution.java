package leetcode;

/**
 * Created by yufeijiang on 9/8/16.
 */

class ResultII{
    public int num;
    public boolean isContinued;
    public ResultII(int n, boolean isC){
        this.num=n;
        this.isContinued=isC;
    }
}

public class CountUnivalueSubtreesSolution {
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null){
            return 0;
        }
        ResultII res=helper(root);
        return res.num;
    }
    public ResultII helper(TreeNode root){
        if(root==null){
            return new ResultII(0, true);
        }
        if(root.left==null && root.right==null){
            return new ResultII(1,true);
        }
        ResultII leftResult=helper(root.left);
        ResultII rightResult=helper(root.right);
        int itself=0;
        boolean isContinued=false;
        if(leftResult.isContinued && rightResult.isContinued){
            int left=root.val;
            int right=root.val;
            if(root.left!=null){
                left=root.left.val;
            }
            if(root.right!=null){
                right=root.right.val;
            }
            if(root.val==left && root.val==right){
                itself=1;
                isContinued=true;
            }
        }
        return new ResultII(leftResult.num+rightResult.num+itself,isContinued);
    }
}

