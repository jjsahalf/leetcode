package leetcode;

/**
 * Created by yufeijiang on 9/23/16.
 */
public class DesignTicTacToe {
    public class TicTacToe {

        private int[] rows;
        private int[] columns;
        private int diagonal;
        private int antiDiagonal;
        private int n;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            rows=new int[n];
            columns=new int[n];
            diagonal=0;
            antiDiagonal=0;
            this.n=n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int score=0;
            if(player==1){
                score=1;
            }else{
                score=-1;
            }
            rows[row]+=score;
            if(rows[row]==n || rows[row]==-n ){
                return player;
            }
            columns[col]+=score;
            if(columns[col]==n || columns[col]==-n){
                return player;
            }
            if(row==col){
                diagonal+=score;
                if(diagonal==n || diagonal==-n){
                    return player;
                }
            }
            if(row+col==n-1){
                antiDiagonal+=score;
                if(antiDiagonal==n || antiDiagonal==-n){
                    return player;
                }
            }
            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
