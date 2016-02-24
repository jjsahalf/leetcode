package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 2/24/16.
 */
public class CombinationSumIISolution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null){
            return null;
        }
        List<List<Integer>> list=new ArrayList();
        if(candidates.length==0){
            return list;
        }
        Arrays.sort(candidates);
        int end=0;
        int length=candidates.length;
        while(end<candidates.length){
            if(candidates[end]>target){
                break;
            }
            end++;
        }
        end-=1;
        List<Integer> innerList=new ArrayList();
        helper(candidates,0,end,target,list,innerList);
        return list;
    }

    public void helper(int[] candidates, int start, int end, int target, List<List<Integer>> list, List<Integer> innerList){
        if(target==0){
            List<Integer> completeList=new ArrayList();
            completeList.addAll(innerList);
            list.add(completeList);
            return;
        }
        if(start>end){
            return;
        }
        if(target<candidates[start]){
            return;
        }
        for(int i=start;i<=end;i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            innerList.add(candidates[i]);
            helper(candidates,i+1,end,target-candidates[i],list,innerList);
            innerList.remove(innerList.size()-1);
        }
    }
}
