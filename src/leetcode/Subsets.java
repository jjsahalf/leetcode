package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 9/13/16.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList();
        if(nums==null || nums.length==0){
            return list;
        }
        List<Integer> curr=new ArrayList();
        helper(nums,list,curr,0);
        return list;
    }
    public void helper(int[] nums, List<List<Integer>> list, List<Integer> curr, int start){
        list.add(new ArrayList(curr));
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            helper(nums,list,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
