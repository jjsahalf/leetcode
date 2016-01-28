package leetcode;

public class InOrderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList();
        if(root==null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
    
}