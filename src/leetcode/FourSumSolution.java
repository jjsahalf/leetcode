package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 2/21/16.
 */



public class FourSumSolution {



    /*
    跟3Sum解法是一样的,只不过再多一层循环.
    
     */


    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null){
            return null;
        }
        List<List<Integer>> list=new ArrayList();
        if(nums.length==0){
            return list;
        }
        Arrays.sort(nums);
        int length=nums.length;

        Set<List<Integer>> set=new HashSet();


        for(int i=0;i<length-3;i++){
            for(int j=i+1;j<length-2;j++){
                int left=j+1;
                int right=length-1;
                int subTarget=target-nums[i]-nums[j];
                while(left<right){
                    if(nums[left]+nums[right]==subTarget){
                        List<Integer> quadruplet=new ArrayList();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[left]);
                        quadruplet.add(nums[right]);
                        if(!set.contains(quadruplet)){
                            set.add(quadruplet);
                            list.add(quadruplet);
                        }
                    }
                    if(nums[left]+nums[right]<subTarget){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return list;

    }

}
