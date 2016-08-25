package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yufeijiang on 8/24/16.
 */
public class SurroundedRegionsSolution {
    private Queue<Node> queue;

    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return;
        }
        for(int i=0;i<board.length;i++){
            queue=new LinkedList<Node>();
            queue.add(new Node(i,0));
            bfs(board, queue);
            queue=new LinkedList<Node>();
            queue.add(new Node(i, board[0].length-1));
            bfs(board, queue);
        }
        for(int j=0;j<board[0].length;j++){
            queue=new LinkedList<Node>();
            queue.add(new Node(0,j));
            bfs(board, queue);
            queue=new LinkedList<Node>();
            queue.add(new Node(board.length-1,j));
            bfs(board,queue);
        }

        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        return;
    }

    public void bfs(char[][]board, Queue<Node> queue){
        while(!queue.isEmpty()){
            Node node=queue.poll();
            int i=node.i;
            int j=node.j;
            if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]=='O'){
                board[i][j]='#';
                queue.add(new Node(i+1, j));
                queue.add(new Node(i-1, j));
                queue.add(new Node(i, j+1));
                queue.add(new Node(i, j-1));
            }
        }
    }
}

class Node{
    public int i;
    public int j;
    public Node(int row, int column){
        i=row;
        j=column;
    }
}
