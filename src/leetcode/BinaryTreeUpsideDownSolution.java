package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 8/13/16.
 */
public class BinaryTreeUpsideDownSolution {
    /*
    这道题还是应该用递归来做,虽然自己的postorder遍历后再按preorder
    读出也是可以的
    public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }
}

     */




    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null) ){
            return root;
        }
        List<Integer> list=new ArrayList();
        postorder(root,list);
        return retrivePreorder(list);
    }

    public void postorder(TreeNode root, List<Integer> list){
        if(root==null){
            list.add(new Integer(-1));
            return;
        }
        if(root.left==null && root.right==null){
            list.add(new Integer(root.val));
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(new Integer(root.val));
    }

    public TreeNode retrivePreorder(List<Integer> list){
        if(list==null || list.size()==0){
            return null;
        }
        TreeNode root=new TreeNode(list.get(0));
        //root.val=list.get(0);
        if(list.size()==1){
            root.left=null;
            root.right=null;
        }else{
            if(list.get(1)==-1){
                root.left=null;
            }else{
                root.left=new TreeNode(list.get(1));
            }
            root.right=retrivePreorder(list.subList(2,list.size()));
        }
        return root;
    }
}
