package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yufeijiang on 10/11/16.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Set<Integer> set=new HashSet();
        for(int i=0; i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=1;
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(!set.contains(curr)){
                continue;
            }
            int upper=curr+1;
            int counter=1;
            set.remove(curr);
            while(set.contains(upper)){
                set.remove(upper);
                upper++;
                counter++;
            }
            int lower=curr-1;
            while(set.contains(lower)){
                set.remove(lower);
                lower--;
                counter++;
            }
            max=Math.max(max,counter);
        }
        return max;
    }
}
