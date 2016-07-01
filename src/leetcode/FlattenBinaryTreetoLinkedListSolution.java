package leetcode;

/**
 * Created by yufeijiang on 6/30/16.
 */

//inorder visit is another way to do this,
//but I will like my solution is more ituiative.
public class FlattenBinaryTreetoLinkedListSolution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }

        if(root.left!=null){
            flatten(root.left);
            TreeNode tail=findTail(root.left);
            TreeNode tempRight=root.right;
            root.right=root.left;
            root.left=null;
            flatten(tempRight);
            tail.right=tempRight;
        }else{
            flatten(root.right);
        }
        return;
    }

    public TreeNode findTail(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }

}
