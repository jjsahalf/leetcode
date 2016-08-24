package leetcode;

/**
 * Created by yufeijiang on 8/24/16.
 */
public class SearchInRotatedSortedArrayIISolution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return false;
        }
        return helper(nums, 0, nums.length-1, target);
    }
    public boolean helper(int[] nums, int start, int end, int target){
        if(start+1<end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]>=nums[start]){
                if(nums[mid]>=target && nums[start]<=target){
                    if(helper(nums,start,mid,target)){
                        return true;
                    }
                }
                if(nums[mid]<=target || nums[end]>=target){
                    if(helper(nums,mid,end,target)){
                        return true;
                    }
                }
            }
            if(nums[mid]<=nums[start]){
                if(nums[mid]<=target && nums[end]>=target){
                    if(helper(nums,mid,end,target)){
                        return true;
                    }
                }
                if(nums[mid]>=target || nums[start]<=target){
                    if(helper(nums,start,mid,target)){
                        return true;
                    }
                }
            }
            return false;

        }else{
            if(nums[start]==target || nums[end]==target){
                return true;
            }
            return false;
        }

    }
}
