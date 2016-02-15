package leetcode;

/**
 * Created by yufeijiang on 2/15/16.
 */
public class MoveZeroesSolution {

    /*
    TWO POINTERS, FROM START TO END.
    USE FIRST ZERO TO SWAP THE FIRST NON ZERO. SWAP IS EVEN BETTER
    public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length<=1) return;
        int first = 0;
        int sec = 0;
        while(sec<nums.length) {
            //find first zero element
            while(first<nums.length && nums[first] !=0) {
                first++;
            }
            if(first == nums.length) return;
            sec = first+1;
            //find following first non-zero element
            while(sec<nums.length && nums[sec] == 0){
                sec++;
            }
            if(sec == nums.length) return;
            swap(nums, first, sec);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

     */



    public void moveZeroes(int[] nums) {
        if(nums==null){
            return;
        }
        if(nums.length==0){
            return;
        }
        int index=nums.length-1;
        int nonZeroZoneEnd=nums.length-1;
        int zeroIndex=-1;
        while(index>=0){
            if(nums[index]!=0){
                index--;
            }else{
                zeroIndex=index;
                for(int i=zeroIndex;i<nonZeroZoneEnd;i++){
                    nums[i]=nums[i+1];
                }
                nums[nonZeroZoneEnd]=0;
                nonZeroZoneEnd--;
                index--;
            }
        }
    }
}
