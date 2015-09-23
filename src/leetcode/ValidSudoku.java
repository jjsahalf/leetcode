package leetcode;

/**
 * Created by yufeijiang on 9/23/15.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board==null){
            return false;
        }


        int[] used=new int[9];


        //check row
        for(int row_index=0;row_index<9;row_index++){
            resetUsedArray(used,9);
            for(int column_index=0;column_index<9;column_index++){
                if(board[row_index][column_index]=='.'){
                    continue;
                }
                char content=board[row_index][column_index];
                int used_index=content-'0'-1;
                if(used[used_index]==0){
                    used[used_index]=1;
                }else{
                    return false;
                }
            }
        }


        //check column
        for(int column_index=0; column_index<9; column_index++){
            resetUsedArray(used,9);
            for(int row_index=0; row_index<9; row_index++){
                if(board[row_index][column_index]=='.'){
                    continue;
                }
                char content=board[row_index][column_index];
                int used_index=content-'0'-1;
                if(used[used_index]==0){
                    used[used_index]=1;
                }else{
                    return false;
                }

            }
        }

        //check small box
        int starting_row=0;
        int starting_column=0;
        for(int i=0;i<9;i++){
            resetUsedArray(used,9);
            boolean res=checkSmallBox(board,starting_row,starting_column,used);
            starting_column+=3;
            if(starting_column==9){
                starting_column=0;
                starting_row+=3;
            }
            if(res){
                continue;
            }else{
                return false;
            }

        }
        return true;
    }

    public boolean checkSmallBox(char[][] board, int starting_row, int starting_column, int[] used){
        for(int row_index=0;row_index<3;row_index++){
            for(int column_index=0;column_index<3;column_index++){
                if(board[starting_row+row_index][starting_column+column_index]=='.'){
                    continue;
                }
                char content=board[starting_row+row_index][starting_column+column_index];
                int used_index=content-'0'-1;
                if(used[used_index]==0){
                    used[used_index]=1;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public void resetUsedArray(int[] array, int length){
        for(int i=0;i<length;i++){
            array[i]=0;
        }
    }



}
