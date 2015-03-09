package leetcode;

//do not check matrix[0][0]
public class SetMatrixZeroesSolution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null){
            return;
        }
        boolean is_first_row_zero=false;
        boolean is_first_column_zero=false;
        //check first row 
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                is_first_row_zero=true;
                break;
            }
        }
        //check first column
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                is_first_column_zero=true;
                break;
            }
        }
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        //key points j=1;
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }
        
        //key points j=1;
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        
        if(is_first_row_zero){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        
        if(is_first_column_zero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        
    }
}
