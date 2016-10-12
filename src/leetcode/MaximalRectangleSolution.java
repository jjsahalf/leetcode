package leetcode;

import java.util.Stack;

/**
 * Created by yufeijiang on 10/11/16.
 */
public class MaximalRectangleSolution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int[] height = new int[matrix[0].length+2];
        int max=0;
        for(int i=0; i<matrix.length;i++){
            Stack<Integer> stack=new Stack();
            for(int j=0;j<matrix[0].length;j++){
                char curr=matrix[i][j];
                if(curr=='0'){
                    height[j+1]=0;
                }
                if(curr=='1'){
                    height[j+1]+=1;

                }
            }
            int j=0;
            while(j<height.length){

                if(stack.isEmpty() || height[j]>=height[stack.peek()]){
                    stack.push(j);
                    j++;

                }else{

                    int h=height[stack.pop()];
                    int width=(j)-stack.peek()-1;
                    int area=h*width;
                    max=Math.max(area,max);
                }
            }
        }
        return max;
    }
}
