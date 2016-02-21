package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> PostOrderTraversalSolution(TreeNode root) {
        List<Integer> result=new LinkedList();
        if(root==null){
            return result; 
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}