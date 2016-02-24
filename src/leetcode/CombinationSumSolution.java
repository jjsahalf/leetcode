package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yufeijiang on 2/24/16.
 */
public class CombinationSumSolution {
    private List<List<Integer>> outterList;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null){
            return null;
        }
        outterList =new ArrayList();
        if(candidates.length==0){
            return this.outterList;
        }
        Arrays.sort(candidates);
        if(target<candidates[0]){
            return this.outterList;
        }
        int end=0;
        while(end<candidates.length){
            if(candidates[end]>target){
                break;
            }
            end++;
        }
        end-=1;

        List<Integer> innerList=new ArrayList();
        helper(candidates,0,end,target,innerList);
        return this.outterList;

    }

    public void helper(int[] candidates, int start, int end, int target, List<Integer> innerList){
        if(target==0){
            List<Integer> completeList=new ArrayList();
            completeList.addAll(innerList);
            this.outterList.add(completeList);
            return;
            //return outterList;
        }
        if(target<candidates[0]){
            //innerList.remove(innerList.size()-1);
            return;
        }
        for(;start<=end;start++){
            //target-=candidates[start];
            innerList.add(candidates[start]);
            helper(candidates, start, end, target-candidates[start],innerList);
            innerList.remove(innerList.size()-1);
        }
    }
    
}
