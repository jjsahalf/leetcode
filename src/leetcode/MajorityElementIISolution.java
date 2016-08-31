package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 8/30/16.
 */
public class MajorityElementIISolution {


    /*
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        int counter=0;
        Stack<TreeNode> stack=new Stack();
        TreeNode mover=root;
        while(mover!=null){
            stack.push(mover);
            mover=mover.left;
        }
        while(mover!=null || (!stack.isEmpty())){
            if(mover==null){
                mover=stack.pop();
                counter++;
                if(counter==k){
                    return mover.val;
                }
                mover=mover.right;
            }else{
                while(mover!=null){
                    stack.push(mover);
                    mover=mover.left;
                }
            }
        }
        return -1;
    }
     */





    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList();
        if(nums==null || nums.length==0){
            return list;
        }
        int num1=0;
        int num2=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(num1==nums[i]){
                count1++;
            }else if(num2==nums[i]){
                count2++;
            }else if(count1==0){
                num1=nums[i];
                count1=1;
            }else if(count2==0){
                num2=nums[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1){
                count1++;
            }else if(nums[i]==num2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            list.add(num1);
        }
        if(count2>nums.length/3){
            list.add(num2);
        }
        return list;
    }
}
