package leetcode;

import java.util.Arrays;

/**
 * Created by yufeijiang on 2/22/16.
 */
public class NextPermutationSolution {
    /*
    从后往前,每一个数字往后看,看有没有比他大的数字,如果有,对后面排序,然后把后面数列中第一个恰好
    大于目标数的交换.
    要是啥都没有,直接强势排序.
     */

    public void nextPermutation(int[] nums) {
        if(nums==null){
            return;
        }
        if(nums.length==0){
            return;
        }
        int length=nums.length;
        for(int i=2;i<=length;i++){
            int currentRoundStartNumber=nums[length-i];
            for(int j=length-i;j<length;j++){
                if(nums[j]>currentRoundStartNumber){
                    for(int counter=length-i+1; counter<length;counter++){
                        for(int k=counter+1;k<length;k++){
                            if(nums[counter]>nums[k]){
                                int temp=nums[k];
                                nums[k]=nums[counter];
                                nums[counter]=temp;
                            }
                        }
                    }
                    for(int counter=length-i+1; counter<length;counter++){
                        if(nums[counter]>nums[length-i]){
                            int temp=nums[counter];
                            nums[counter]=nums[length-i];
                            nums[length-i]=temp;
                            return;
                        }
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }
}
