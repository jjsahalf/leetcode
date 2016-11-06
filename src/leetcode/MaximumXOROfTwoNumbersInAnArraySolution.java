package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yufeijiang on 11/5/16.
 */
public class MaximumXOROfTwoNumbersInAnArraySolution {
    public int findMaximumXOR(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int mask=0;
        int max=0;
        for(int i=31;i>=0;i--){
            mask=mask | (1<<i);
            Set<Integer> set=new HashSet();
            for(int num:nums){
                set.add(num & mask);
            }
            int tempMax=max | (1<<i);
            for(int num : set){
                if(set.contains(tempMax ^ num)){
                    max=tempMax;
                    break;
                }
            }
        }
        return max;
    }
}
