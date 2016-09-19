package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yufeijiang on 9/19/16.
 */
public class PopulatingNextRightPointersInEachNodeIISolution {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        Queue<TreeLinkNode> queue=new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize-1;i++){
                TreeLinkNode leftNode=queue.poll();
                if(leftNode.left!=null){
                    queue.add(leftNode.left);
                }
                if(leftNode.right!=null){
                    queue.add(leftNode.right);
                }
                TreeLinkNode rightNode=queue.peek();
                leftNode.next=rightNode;
            }
            TreeLinkNode rightEnd=queue.poll();
            if(rightEnd.left!=null){
                queue.add(rightEnd.left);
            }
            if(rightEnd.right!=null){
                queue.add(rightEnd.right);
            }
            rightEnd.next=null;
        }
    }
}
