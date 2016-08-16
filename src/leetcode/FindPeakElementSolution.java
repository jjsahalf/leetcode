package leetcode;

/**
 * Created by yufeijiang on 8/16/16.
 */
public class FindPeakElementSolution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle=(left+right)/2;
            if((middle==0 || nums[middle]>nums[middle-1]) && (middle==nums.length-1 || nums[middle]>nums[middle+1])){
                return middle;
            }
            if(middle>0 && nums[middle]<nums[middle-1]){
                right=middle-1;
                continue;
            }
            if(middle<nums.length-1 && nums[middle]<nums[middle+1]){
                left=middle+1;
                continue;
            }
        }

        return -1;
    }
}
