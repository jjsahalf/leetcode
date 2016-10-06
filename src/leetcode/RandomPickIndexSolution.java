package leetcode;

import java.util.Random;

/**
 * Created by yufeijiang on 10/6/16.
 */
public class RandomPickIndexSolution {
    private int[] nums;
    private Random random;

    public RandomPickIndexSolution(int[] nums) {
        this.nums=nums;
        random=new Random();
    }

    public int pick(int target) {
        int counter=0;
        int result=-1;
        while(nums[counter]!=target){
            counter++;
        }
        int startPoint=counter;
        while(counter<nums.length && nums[counter]==target){
            if(random.nextInt(counter-startPoint+1)==0){
                result=counter;
            }
            counter++;
        }
        return result;
    }
}
