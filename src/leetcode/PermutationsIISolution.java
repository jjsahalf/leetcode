package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yufeijiang on 3/22/16.
 */
public class PermutationsIISolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList();
        List<Integer> localList=new ArrayList();
        if(nums.length==0 || nums ==null)
            return result;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums,result,localList,visited);
        return result;
    }
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> localList, boolean[] visited){
        if(localList.size()==nums.length){
            result.add(new ArrayList(localList));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i-1]==nums[i] && !visited[i-1]){
                continue;
            }
            if(!visited[i]){
                localList.add(nums[i]);
                visited[i]=true;
                helper(nums,result,localList,visited);
                localList.remove(localList.size()-1);
                visited[i]=false;
            }
        }
    }
}
