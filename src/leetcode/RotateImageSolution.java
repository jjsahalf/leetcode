package leetcode;

/**
 * Created by yufeijiang on 3/23/16.
 */
public class RotateImageSolution {
    //不能有裸露的i出现!
    public void rotate(int[][] matrix) {
        if(matrix==null){
            return;
        }
        if(matrix.length==0){
            return;
        }

        int start=0;
        int end=matrix.length-1;
        int temp1=0;
        int temp2=0;

        while(start<=end){
            for(int i=0;i<end-start;i++){
                temp1=matrix[start+i][end];
                matrix[start+i][end]=matrix[start][start+i];
                temp2=matrix[end][end-i];
                matrix[end][end-i]=temp1;
                temp1=matrix[end-i][start];
                matrix[end-i][start]=temp2;
                matrix[start][start+i]=temp1;
            }
            start++;
            end--;
        }
    }
}
