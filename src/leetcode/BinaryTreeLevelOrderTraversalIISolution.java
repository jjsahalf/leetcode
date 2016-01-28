package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 1/28/16.
 */
public class BinaryTreeLevelOrderTraversalIISolution {


    /*

        A BETTER SOLUTION: TAKING ADVANTAGE OF QUEUE.

        public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currLevelNodeNum = 1;
        int nextLevelNodeNum = 0;

        while (currLevelNodeNum != 0) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
            nextLevelNodeNum = 0;

            while (currLevelNodeNum != 0) {
                TreeNode node = queue.poll();

                currLevelNodeNum--;
                currLevelResult.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelNodeNum++;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNodeNum++;
                }
            }

            result.add(0, currLevelResult);
            currLevelNodeNum = nextLevelNodeNum;
        }
        return result;
    }
     */



    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList();
        if(root==null){
            return result;
        }


        List<List<TreeNode>> topToBottom =new ArrayList();

        List<TreeNode> it=new ArrayList();
        it.add(root);
        topToBottom.add(it);

        while(checkNull(topToBottom.get(topToBottom.size()-1))){
            List<TreeNode> lastLevelList=topToBottom.get(topToBottom.size()-1);
            List<TreeNode> nextLevelList=new ArrayList();
            for(TreeNode node: lastLevelList){
                if(node!=null){
                    nextLevelList.add(node.left);
                    nextLevelList.add(node.right);
                }
            }
            topToBottom.add(nextLevelList);
        }
        topToBottom.remove(topToBottom.size()-1);


        result=new ArrayList();

        for(int i=topToBottom.size()-1; i>=0; i--){
            List<TreeNode> itNode=topToBottom.get(i);
            List<Integer> itInt=new ArrayList();
            for(TreeNode node:itNode){
                if(node!=null){
                    itInt.add(node.val);
                }
            }
            result.add(itInt);
        }

        return result;



    }

    boolean checkNull(List<TreeNode> list){
        for(TreeNode node:list){
            if(node!=null){
                return true;
            }
        }
        return false;
    }
}
