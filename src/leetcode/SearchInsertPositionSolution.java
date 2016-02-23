package leetcode;

/**
 * Created by yufeijiang on 2/23/16.
 */
public class SearchInsertPositionSolution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null){
            return 0;
        }
        if(nums.length==0){
            return 0;
        }
        int length=nums.length;
        if(target>nums[nums.length-1]){
            return length;
        }
        if(target<nums[0]){
            return 0;
        }

        int left=0;
        int right=length-1;

        while(left<right){
            int middle=(left+right)/2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]>target){
                right=middle;
            }else if(nums[middle]<target){
                left=middle+1;
            }
        }

        return right;
    }
}
