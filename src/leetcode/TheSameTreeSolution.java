package leetcode;

//import javax.swing.tree.TreeNode;

/**
 * Created by yufeijiang on 9/30/15.
 */
public class TheSameTreeSolution {
    //if root, left-sub-tree, and right-sub-tree are identical, then the tree is identical.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        boolean isLeftSubTreeIdentical=false;
        boolean isRightSubTreeIdentical=false;
        boolean isRootIdentical=false;
        if(p!=null && q!=null && p.val==q.val){
            isRootIdentical=true;
        }

        if(isRootIdentical==false){
            return false;
        }

        isLeftSubTreeIdentical=isSameTree(p.left,q.left);
        if(isLeftSubTreeIdentical==false){
            return false;
        }

        isRightSubTreeIdentical=isSameTree(p.right,q.right);
        if(isRightSubTreeIdentical==false){
            return false;
        }

        return true;
    }
}
