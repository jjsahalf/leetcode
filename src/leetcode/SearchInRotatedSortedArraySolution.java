package leetcode;

/**
 * Created by yufeijiang on 8/23/16.
 */
public class SearchInRotatedSortedArraySolution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int start=0;
        int end=nums.length-1;
        int mid;
        while(start+1<end){
            mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>nums[start]){
                if(nums[start]<=target && nums[mid]>=target){
                    end=mid;
                }else{
                    start=mid;
                }
            }else{
                if(nums[mid]<=target && nums[end]>=target){
                    start=mid;
                }else{
                    end=mid;
                }
            }
        }
        if(nums[start]==target){
            return start;
        }
        if(nums[end]==target){
            return end;
        }
        return -1;
    }
}
