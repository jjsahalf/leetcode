package leetcode;

/**
 * Created by yufeijiang on 2/19/16.
 */
public class ContainerWithMostWaterSolution {

    /*
    认真审题,一次遍历!
     */

    public int maxArea(int[] height) {
        if(height==null){
            return -1;
        }
        if(height.length==0){
            return -1;
        }

        int maxArea=0;
        int area=0;

        int left=0;
        int right=height.length-1;

        while(left<right){
            area=(right-left)*Math.min(height[left],height[right]);
            if(area>maxArea){
                maxArea=area;
            }
            if(height[left]<height[right]){
                int leftCounter=left+1;
                while(leftCounter<right && height[leftCounter]<=height[left]){
                    leftCounter++;
                }
                left=leftCounter;
            }else{
                int rightCounter=right-1;
                while(rightCounter>left && height[rightCounter]<=height[right]){
                    rightCounter--;
                }
                right=rightCounter;
            }
        }


        return maxArea;
    }
}
