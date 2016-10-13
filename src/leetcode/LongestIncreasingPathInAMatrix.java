package leetcode;

/**
 * Created by yufeijiang on 10/13/16.
 */
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int[][] mem=new int[matrix.length][matrix[0].length];
        for(int i=0; i<mem.length;i++){
            for(int j=0; j<mem[0].length;j++){
                mem[i][j]=-1;
            }
        }
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[0].length; j++){
                helper(matrix, i, j, mem);
            }
        }
        int max=0;
        for(int i=0; i<mem.length;i++){
            for(int j=0; j<mem[0].length;j++){
                max=Math.max(max, mem[i][j]);
            }
        }
        return max;
    }
    public void helper(int[][] matrix, int row, int col, int[][] mem){
        if(mem[row][col]!=-1){
            return;
        }
        int max=1;
        mem[row][col]=1;
        if(row-1>=0 && matrix[row-1][col]>matrix[row][col]){
            helper(matrix, row-1, col, mem);
            max=Math.max(mem[row-1][col]+1, max);
        }
        if(row+1<matrix.length && matrix[row+1][col]>matrix[row][col]){
            helper(matrix, row+1, col, mem );
            max=Math.max(mem[row+1][col]+1, max);
        }
        if(col-1>=0 && matrix[row][col-1]>matrix[row][col]){
            helper(matrix, row, col-1, mem);
            max=Math.max(mem[row][col-1]+1,max);
        }
        if(col+1<matrix[0].length && matrix[row][col+1]>matrix[row][col]){
            helper(matrix, row, col+1, mem);
            max=Math.max(mem[row][col+1]+1, max);
        }
        mem[row][col]=max;
    }
}
