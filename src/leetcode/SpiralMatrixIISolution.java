package leetcode;

/**
 * Created by yufeijiang on 3/28/16.
 */
public class SpiralMatrixIISolution {
    public int[][] generateMatrix(int n) {
        if(n<=0){
            return new int[0][0];
        }
        int[][] matrix=new int[n][n];

        int start=0;
        int end=n-1;
        int counter=1;
        while(start<=end){
            if(start==end){
                matrix[start][start]=counter;
                break;
            }
            for(int i=0;i<end-start;i++){
                matrix[start][start+i]=counter;
                matrix[start+i][end]=counter+end-start;
                matrix[end][end-i]=counter+(end-start)*2;
                matrix[end-i][start]=counter+(end-start)*3;
                counter++;
            }
            counter+=(end-start)*3;
            start++;
            end--;
        }

        return matrix;

    }
}
