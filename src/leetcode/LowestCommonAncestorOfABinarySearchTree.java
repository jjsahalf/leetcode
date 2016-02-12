package leetcode;

/**
 * Created by yufeijiang on 2/12/16.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if((p.val-root.val)*(q.val-root.val)<=0){
            return root;
        }

        TreeNode result=null;

        if((p.val-root.val)<0){
            result=lowestCommonAncestor(root.left, p, q);
        }else{
            result=lowestCommonAncestor(root.right, p, q);
        }

        return result;
    }
}
