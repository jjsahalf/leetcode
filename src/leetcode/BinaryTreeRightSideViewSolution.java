package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yufeijiang on 8/29/16.
 */
public class BinaryTreeRightSideViewSolution {

    /*
    诀窍是维护了一个maxDepth, 每次递归都先又后左,之前没来过这么深才会加入list
    int maxdepth = 0;
    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new LinkedList<Integer>();
        if(root!=null) helper(root,1);
        return res;
    }

    private void helper(TreeNode root, int depth){
        if(depth>maxdepth){
            maxdepth = depth;
            res.add(root.val);
        }
        if(root.right!=null) helper(root.right, depth+1);
        if(root.left!=null) helper(root.left, depth+1);
    }
     */



    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            TreeNode rightSide=null;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node==null){
                    continue;
                }
                queue.offer(node.left);
                queue.offer(node.right);
                rightSide=node;
            }
            if(rightSide!=null){
                list.add(rightSide.val);
            }
        }
        return list;
    }
}
