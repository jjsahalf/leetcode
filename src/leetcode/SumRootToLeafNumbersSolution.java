package leetcode;

/**
 * Created by yufeijiang on 7/7/16.
 */
public class SumRootToLeafNumbersSolution {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return dfs(root, 0, 0);
    }

    public int dfs(TreeNode root, int sum, int localSum){
        localSum+=root.val;
        if(root.left==null && root.right==null){
            sum+=localSum;
            return sum;
        }else{
            localSum*=10;
            if(root.left!=null){
                sum=dfs(root.left,sum, localSum);
            }
            if(root.right!=null){
                sum=dfs(root.right,sum,localSum);
            }
            return sum;
        }
    }
}
