package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yufeijiang on 9/25/15.
 */
public class ContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null){
            return false;
        }
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0; i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
