package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 6/22/16.
 */

//Facebook
//Array, Backtracking

public class SubsetsIISolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> fullList = new ArrayList();
        List<Integer> list =new ArrayList();
        Set<List<Integer>> set=new HashSet();
        fullList.add(list);
        if(nums==null || nums.length==0){
            return fullList;
        }

        Arrays.sort(nums);

        helper(set, list, nums, 0);

        for(List<Integer> item: set){
            fullList.add(item);
        }

        return fullList;

    }

    public void helper(Set<List<Integer>> set, List<Integer> list, int[] nums, int index){
        if(index==nums.length){
            return;
        }

        for(int i=index; i<nums.length;i++){
            list.add(nums[i]);
            List newList=new ArrayList(list);
            set.add(newList);
            helper(set, list, nums, i+1);
            list.remove(list.size()-1);
        }


    }
}
