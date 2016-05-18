package leetcode;

/**
 * Created by yufeijiang on 5/18/16.
 */
public class Search2DMatrix {

    /*
    也可以不用递归
    public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length, column = matrix[0].length;
        int start = 0, end = row * column - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            if (number == target) {
                return true;
            } else if (number < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / column][start % column] == target) {
            return true;
        } else if (matrix[end / column][end % column] == target) {
            return true;
        }

        return false;
    }
}



     */



    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null){
            return false;
        }
        if(matrix.length==0){
            return false;
        }

        int row=matrix.length;
        int column=matrix[0].length;

        boolean isThere;
        isThere= rec(0,(row*column-1)/2, target, row, column, matrix) || rec((row*column-1)/2+1,row*column-1, target, row, column, matrix);

        return isThere;


    }

    public boolean rec(int lowIndex, int highIndex, int target, int row, int column, int[][] matrix){
        int lowRow=lowIndex/column;
        int lowColumn=lowIndex%column;
        int highRow=highIndex/column;
        int highColumn=highIndex%column;

        if(lowIndex>highIndex){
            return false;
        }


        if(lowIndex==highIndex){
            if(target==matrix[lowRow][lowColumn]){
                return true;
            }else{
                return false;
            }
        }

        return (rec(lowIndex, (lowIndex+highIndex)/2, target, row, column, matrix ) || rec((lowIndex+highIndex)/2+1, highIndex, target, row, column, matrix));

    }
}
