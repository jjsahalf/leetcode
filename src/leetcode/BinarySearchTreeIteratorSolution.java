package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 8/19/16.
 */
public class BinarySearchTreeIteratorSolution {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    /*
    我的解法应该说不是很好,正路解法应该是注释里这个
    public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }


    public boolean hasNext() {
        return !stack.isEmpty();
    }


    public int next() {
        TreeNode node = stack.pop();
        int ret = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return ret;
    }
}  
     */


    public class BSTIterator {

        private List<TreeNode> list;
        private int counter;

        public BSTIterator(TreeNode root) {
            list=new ArrayList();
            inorder(root, list);
            counter=0;
        }

        private void inorder(TreeNode root, List<TreeNode> list){
            if(root==null){
                return;
            }
            inorder(root.left,list);
            list.add(root);
            inorder(root.right,list);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(counter<list.size()){
                return true;
            }else{
                return false;
            }
        }

        /** @return the next smallest number */
        public int next() {
            int index=counter;
            counter++;
            return list.get(index).val;
        }
    }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
