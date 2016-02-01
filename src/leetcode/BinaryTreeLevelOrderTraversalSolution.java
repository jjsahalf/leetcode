package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yufeijiang on 2/1/16.
 */
public class BinaryTreeLevelOrderTraversalSolution {

    //USING QUEUE IS OK.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listOfList=new ArrayList();
        Queue<TreeNode> helperQueue=new LinkedList();

        helperQueue.add(root);

        while(checkNotAllNull(helperQueue)){
            int currentLevelSize=helperQueue.size();
            List<Integer> list=new ArrayList();
            for(TreeNode node:helperQueue){
                if(node!=null){
                    list.add(node.val);
                }
            }
            listOfList.add(list);

            for(int i=0;i<currentLevelSize;i++){
                TreeNode tempNode=helperQueue.poll();
                if(tempNode!=null){
                    helperQueue.add(tempNode.left);
                    helperQueue.add(tempNode.right);
                }
            }
        }

        return listOfList;
    }

    protected boolean checkNotAllNull(Queue<TreeNode> queue){
        for(TreeNode node:queue){
            if(node!=null){
                return true;
            }
        }
        return false;
    }
}
