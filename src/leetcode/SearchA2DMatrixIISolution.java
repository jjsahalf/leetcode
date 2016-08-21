package leetcode;

/**
 * Created by yufeijiang on 8/21/16.
 */
public class SearchA2DMatrixIISolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }

        int row=matrix.length-1;
        int column=0;
        while(row>=0 && column<matrix[0].length){
            if(matrix[row][column]==target){
                return true;
            }
            if(matrix[row][column]>target){
                row--;
            }else{
                column++;
            }
        }

        return false;


    }
}
