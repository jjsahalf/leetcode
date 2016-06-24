package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 6/24/16.
 */
public class UniqueBinarySearchTreesIISolution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list =new ArrayList();
        if(n==0){
            return list;
        }
        if(n==1){
            TreeNode tn=new TreeNode(1);
            list.add(tn);
            return list;
        }



        List<List<TreeNode>> all=new ArrayList();
        List<TreeNode> list0= new ArrayList();
        TreeNode node0=null;
        list0.add(node0);
        all.add(list0);

        List<TreeNode> list1 = new ArrayList();
        TreeNode node1= new TreeNode(1);
        list1.add(node1);
        all.add(list1);


        for(int i=2; i<=n; i++){
            /*List<TreeNode> listI=new ArrayList();
            for(TreeNode smallHead: all.(i-1)){
                TreeNode bigHead=new TreeNode(i);
                bigHead.left=smallHead;
                listI.add(bigHead);
            }*/

            List<TreeNode> listI=new ArrayList();
            for(int headNumber=1; headNumber<=i; headNumber++){
                int leftTreeListIndex=headNumber-1;
                int rightTreeListIndex=i-1-(headNumber-1);
                List<TreeNode> leftTreeList=all.get(leftTreeListIndex);
                List<TreeNode> rightTreeList=all.get(rightTreeListIndex);
                for(TreeNode leftSubTreeHead: leftTreeList){
                    for(TreeNode rightSubTreeHead: rightTreeList){
                        TreeNode node=new TreeNode(headNumber);
                        if(leftSubTreeHead==null){
                            node.left=null;
                        }else{
                            TreeNode realLeftSubTreeHead=new TreeNode(leftSubTreeHead.val);
                            realLeftSubTreeHead.left=leftSubTreeHead.left;
                            realLeftSubTreeHead.right=leftSubTreeHead.right;
                            node.left=realLeftSubTreeHead;
                        }


                        node.left=leftSubTreeHead;
                        if(rightSubTreeHead==null){
                            node.right=null;
                        }else{



                            TreeNode realRightSubTreeHead=new TreeNode(rightSubTreeHead.val);
                            realRightSubTreeHead.left=rightSubTreeHead.left;
                            realRightSubTreeHead.right=rightSubTreeHead.right;
                            realRightSubTreeHead=lift(realRightSubTreeHead, headNumber);
                            node.right=realRightSubTreeHead;
                        }

                        listI.add(node);
                    }
                }
            }
            all.add(listI);


        }

        return all.get(n);

    }



    public TreeNode lift(TreeNode head, int headNumber){
        if(head==null){
            return null;
        }
        TreeNode node=new TreeNode(head.val+headNumber);
        node.left=lift(head.left,headNumber);
        node.right=lift(head.right,headNumber);


        return node;

    }
}
