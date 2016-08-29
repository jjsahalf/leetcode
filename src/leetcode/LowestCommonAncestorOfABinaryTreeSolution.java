package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 8/29/16.
 */
public class LowestCommonAncestorOfABinaryTreeSolution {

    /*
    九章算法的解法最为经典!
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        // Divide
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);

        // Conquer
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;


其他人也有和我大同小异的解法, findNode用一个boolean当返回值可以提供更多信息 更好一些

            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> sp = new Stack<TreeNode>();
        Stack<TreeNode> sq = new Stack<TreeNode>();
        findNode(root, p, sp);
        findNode(root, q, sq);
        TreeNode target = root;
        TreeNode temp;
        while(!sp.isEmpty() && !sq.isEmpty()){
            temp = sp.pop();
            if(temp == sq.pop()) {
                target = temp;
            }
            else{
                break;
            }
        }
        return target;
    }

    public boolean findNode(TreeNode root, TreeNode p, Stack<TreeNode> s) {
        if(root == null) {
            return false;
        }
        if(root == p) {
            s.push(root);
            return true;
        }else if(findNode(root.left, p, s) || findNode(root.right, p,s)) {
            s.push(root);
            return true;
        }else{
            return false;
        }
    }


     */




    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        List<TreeNode> pList=new ArrayList();
        List<TreeNode> qList=new ArrayList();
        findPath(root, p, pList);
        findPath(root, q, qList);
        TreeNode lca=root;
        for(int i=0;i<pList.size() && i<qList.size();i++){
            if(pList.get(i)==qList.get(i)){
                lca=pList.get(i);
            }else{
                break;
            }
        }
        return lca;
    }

    public void findPath(TreeNode root, TreeNode node, List<TreeNode> list){
        if(root==null){
            return;
        }
        list.add(root);
        if(root==node){
            return;
        }else{
            int size=list.size();
            findPath(root.left, node,list);
            if(size!=list.size()){
                return;
            }
            findPath(root.right, node, list);
            if(size!=list.size()){
                return;
            }
            list.remove(list.size()-1);
            return;
        }
    }
}
