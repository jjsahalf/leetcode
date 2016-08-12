package leetcode;

/**
 * Created by yufeijiang on 8/12/16.
 */
public class FindMinimumInRotatedSortedArrayIISolution {
    /*
    my own solution can just AC, but not elegant at all!
    和Search in Rotated Sorted Array II这题换汤不换药。同样当A[mid] = A[end]时，无法判断min究竟在左边还是右边。

3 1 2 3 3 3 3
3 3 3 3 1 2 3

但可以肯定的是可以排除A[end]：因为即使min = A[end]，由于A[end] = A[mid]，排除A[end]并没有让min丢失。所以增加的条件是：

A[mid] = A[end]：搜索A[start : end-1]

class Solution {
public:
    int findMin(vector<int> &num) {
        int start = 0, end = num.size()-1;
        while(start<end) {
            int mid = start + (end-start)/2;
            if(num[mid]<num[end])
                end = mid;
            else if(num[mid]>num[end])
                start = mid+1;
            else
                end--;
        }
        return num[start];
    }
};

     */


    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        return helper(nums,0,nums.length-1);
    }
    public int helper(int[] nums, int low, int high){

        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]==nums[low] && nums[mid]==nums[high]){
                if(low==mid){
                    return nums[low];
                }
                return Math.min(helper(nums,low,mid), helper(nums, mid, high));
            }
            if(nums[mid]<nums[high] || ( nums[mid]==nums[high] && nums[mid]<nums[low])){
                high=mid;
            }else if(nums[mid]==nums[high] && nums[mid]>nums[low]){
                return nums[low];
            }else{
                low=mid+1;
            }
        }
        return nums[low];
    }
}
