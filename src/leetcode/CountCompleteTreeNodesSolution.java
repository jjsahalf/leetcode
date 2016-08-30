package leetcode;

/**
 * Created by yufeijiang on 8/30/16.
 */
public class CountCompleteTreeNodesSolution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth=findLeftDepth(root);
        int rightDepth=findRightDepth(root);
        if(leftDepth==rightDepth){
            int res=1;
            for(int i=0;i<leftDepth;i++){
                res*=2;
            }
            return res-1;
        }else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
    public int findLeftDepth(TreeNode root){
        int level=0;
        while(root!=null){
            root=root.left;
            level++;
        }
        return level;
    }
    public int findRightDepth(TreeNode root){
        int level=0;
        while(root!=null){
            root=root.right;
            level++;
        }
        return level;
    }
}
