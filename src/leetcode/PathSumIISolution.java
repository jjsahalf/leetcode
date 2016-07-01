package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 6/30/16.
 */
public class PathSumIISolution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allList=new ArrayList();
        List<Integer> list=new ArrayList();

        dfs(root, sum, allList, list);

        return allList;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> allList, List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==sum){
                List<Integer> newList=new ArrayList(list);
                allList.add(newList);
                list.remove(list.size()-1);
                return;
            }
        }

        if(root.left!=null){
            dfs(root.left, sum-root.val, allList, list);
        }
        //list.remove(list.size()-1);
        if(root.right!=null){
            dfs(root.right, sum-root.val, allList, list);
        }

        list.remove(list.size()-1);

        return;


    }
}
