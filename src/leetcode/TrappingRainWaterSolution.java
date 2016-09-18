package leetcode;

/**
 * Created by yufeijiang on 9/18/16.
 */
public class TrappingRainWaterSolution {
    public int trap(int[] height) {
        if(height==null || height.length<3){
            return 0;
        }
        return helper(0,height.length-1,-1,height.length,height);

    }

    public int helper(int start, int end, int leftMaxIndex, int rightMaxIndex, int[] height){
        int maxIndex;
        if(start<end){
            maxIndex=findMaxIndex(start, end, height);
        }else{
            return 0;
        }
        int totalWater=0;
        if(leftMaxIndex!=-1){
            for(int i=leftMaxIndex+1; i<maxIndex; i++){
                totalWater+=(height[maxIndex]-height[i]);
            }
        }
        if(rightMaxIndex!=height.length){
            for(int i=maxIndex+1;i<rightMaxIndex;i++){
                totalWater+=(height[maxIndex]-height[i]);
            }
        }
        int leftWater=0;
        int rightWater=0;
        if(start==0){
            leftWater=helper(start, maxIndex-1, -1, maxIndex, height);
        }
        if(end==height.length-1){
            rightWater=helper(maxIndex+1, end, maxIndex, height.length, height);
        }
        return totalWater+leftWater+rightWater;
    }


    public int findMaxIndex(int start, int end, int[] height){
        int maxValue=Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=start;i<=end;i++){
            if(height[i]>maxValue){
                maxValue=height[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}
