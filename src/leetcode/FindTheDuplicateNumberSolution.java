package leetcode;

/**
 * Created by yufeijiang on 9/19/16.
 */
public class FindTheDuplicateNumberSolution {
    /*
    public int findDuplicate(int[] nums) {
        if(nums==null || nums.length==0){
            return Integer.MIN_VALUE;
        }
        int start=1;
        int end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            int counter=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid){
                    counter++;
                }
            }
            if(counter>mid){
                end=mid;
            }else{
                start=mid;
            }
        }
        int counter=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==start){
                counter++;
                if(counter>=2){
                    return start;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==end){
                counter++;
                if(counter>=2){
                    return end;
                }
            }
        }
        return -1;
    }*/
    public int findDuplicate(int[] nums) {
        if(nums==null || nums.length==0){
            return Integer.MIN_VALUE;
        }
        int slow=0;
        int fast=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        int find=0;
        while(slow!=find){
            slow=nums[slow];
            find=nums[find];
        }
        return slow;
    }
}
