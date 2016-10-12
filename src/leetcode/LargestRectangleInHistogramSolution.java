package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 10/11/16.
 */
public class LargestRectangleInHistogramSolution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0){
            return 0;
        }
        Stack<Integer> stack=new Stack();
        int[] extHeights=new int[heights.length+2];
        extHeights[0]=0;
        extHeights[extHeights.length-1]=0;
        for(int i=0;i<heights.length;i++){
            extHeights[i+1]=heights[i];
        }
        int max=0;
        int i=0;
        while(i<extHeights.length){
            if(stack.isEmpty() || extHeights[i]>=extHeights[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int height=extHeights[stack.pop()];
                int width=i-stack.peek()-1;
                int area=height*width;
                max=Math.max(area,max);
            }
        }
        return max;
    }
}
