package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 1/28/16.
 */
public class SymmetricTree {

    /*
    // CORRECT SOLUTION!!

    public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return check(root1.left, root2.right) && check(root1.right, root2.left);
    }
}


     */









    public boolean isSymmetric(TreeNode root) {

        if(root==null){
            return true;
        }

        if(root.left==null && root.right==null){
            return true;
        }

        if(root.left==null || root.right==null){
            return false;
        }

        if(root.left.val!=root.right.val){
            return false;
        }

        List<String> inOrderList=new ArrayList();
        inOrderTraversal(inOrderList, root);

        for(int i=0; i<inOrderList.size()/2; i++){
            if(!inOrderList.get(i).equals(inOrderList.get(inOrderList.size()-i-1))){
                return false;
            }
        }

        return true;
    }


    protected void inOrderTraversal(List<String> inOrderList, TreeNode node){

        if(node==null){
            inOrderList.add("#");
            return;
        }else if(node.left==null && node.right==null){
            Integer value=node.val;
            inOrderList.add(value.toString());
            return;
        }else{
            inOrderTraversal(inOrderList, node.left);
            Integer value=node.val;
            inOrderList.add(value.toString());
            inOrderTraversal(inOrderList, node.right);
        }
    }
}
