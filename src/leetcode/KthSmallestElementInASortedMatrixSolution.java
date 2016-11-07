package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yufeijiang on 11/7/16.
 */
public class KthSmallestElementInASortedMatrixSolution {

    class Cell{
        int row;
        int col;
        int val;
        public Cell(int r, int c, int v){
            this.row=r;
            this.col=c;
            this.val=v;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        PriorityQueue<Cell> pq=new PriorityQueue(new Comparator<Cell>(){
            public int compare(Cell a, Cell b){
                return a.val-b.val;
            }
        });
        for(int i=0; i<matrix.length; i++){
            pq.offer(new Cell(i, 0, matrix[i][0]));
        }
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        int res=0;
        Cell curr;
        for(int i=0; i<k; i++){
            curr=pq.poll();
            res=curr.val;
            if(curr.col+1<matrix[0].length){
                pq.offer(new Cell(curr.row, curr.col+1, matrix[curr.row][curr.col+1]));
            }
        }
        return res;
    }
}
