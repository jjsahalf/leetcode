package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 7/6/16.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }else{
            List<TreeLinkNode> list=new ArrayList();
            list.add(root);
            bfs(list);
            return;
        }
    }


    public void bfs(List<TreeLinkNode> list){
        if(list==null || list.size()==0){
            return;
        }else{
            List<TreeLinkNode> nextList=new ArrayList();
            for(int i=0;i<list.size()-1;i++){
                TreeLinkNode current=list.get(i);
                current.next=list.get(i+1);
                if(current.left!=null){
                    nextList.add(current.left);
                }
                if(current.right!=null){
                    nextList.add(current.right);
                }
            }
            TreeLinkNode last=list.get(list.size()-1);
            last.next=null;
            if(last.left!=null){
                nextList.add(last.left);
            }
            if(last.right!=null){
                nextList.add(last.right);
            }
            bfs(nextList);
        }
    }
}
