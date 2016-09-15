package leetcode;

/**
 * Created by yufeijiang on 9/15/16.
 */
public class GameOfLIfe {
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int number=count(board, i, j);
                if((number>3 || number<2) && board[i][j]==1 ){
                    board[i][j]=2;
                }
                if((number==3) && board[i][j]==0 ){
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
    public int count(int[][] board, int i, int j){
        int liveNeighbor=0;
        liveNeighbor+=probe(board, i+1,j);
        liveNeighbor+=probe(board, i-1,j);
        liveNeighbor+=probe(board, i,j+1);
        liveNeighbor+=probe(board, i,j-1);
        liveNeighbor+=probe(board, i+1,j+1);
        liveNeighbor+=probe(board, i+1,j-1);
        liveNeighbor+=probe(board, i-1,j+1);
        liveNeighbor+=probe(board, i-1,j-1);
        return liveNeighbor;
    }
    public int probe(int[][] board, int i, int j){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length){
            if(board[i][j]==1 || board[i][j]==2){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
}
