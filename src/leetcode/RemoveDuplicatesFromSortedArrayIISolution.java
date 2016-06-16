package leetcode;

/**
 * Created by yufeijiang on 6/16/16.
 */
public class RemoveDuplicatesFromSortedArrayIISolution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int slow=0;
        int fast=0;


        int counter=0;
        int currentNumber=nums[0];

        while(fast<nums.length){
            if(nums[fast]==currentNumber){
                counter++;
            }else{
                counter=1;
                currentNumber=nums[fast];
            }

            if(counter>=3){
                fast++;
            }else{
                nums[slow]=nums[fast];
                slow++;
                fast++;
            }
        }

        return slow;


    }
}
