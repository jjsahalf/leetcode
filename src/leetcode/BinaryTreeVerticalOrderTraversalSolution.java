package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 8/29/16.
 */

class PosNode{
    TreeNode node;
    Integer pos;
    PosNode(TreeNode n, Integer x){
        node=n;
        pos=x;
    }
}


public class BinaryTreeVerticalOrderTraversalSolution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> resList=new ArrayList();
        if(root==null){
            return resList;
        }
        Map<Integer,List<Integer>> map=new HashMap();
        Queue<PosNode> queue=new LinkedList();
        PosNode firstPosNode=new PosNode(root, 0);
        queue.offer(firstPosNode);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                PosNode pn=queue.poll();
                Integer pos=pn.pos;
                TreeNode node=pn.node;
                if(node==null){
                    continue;
                }
                if(map.containsKey(pos)){
                    map.get(pos).add(node.val);
                }else{
                    List<Integer> list=new ArrayList();
                    list.add(node.val);
                    map.put(pos,list);
                }
                queue.offer(new PosNode(node.left, pos-1));
                queue.offer(new PosNode(node.right, pos+1));
            }
        }
        Set<Integer> set=map.keySet();
        List<Integer> list=new ArrayList();
        for(Integer i:set){
            list.add(i);
        }
        Collections.sort(list);
        for(Integer i:list){
            resList.add(map.get(i));
        }
        return resList;
    }
}
