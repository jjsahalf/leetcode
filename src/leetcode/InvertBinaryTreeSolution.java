package leetcode;

/**
 * Created by yufeijiang on 2/8/16.
 */
public class InvertBinaryTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        if(root.left==null && root.right==null){
            return root;
        }
        TreeNode originalLeft=root.left;
        TreeNode originalRight=root.right;
        root.left=invertTree(originalRight);
        root.right=invertTree(originalLeft);
        return root;

    }
}
