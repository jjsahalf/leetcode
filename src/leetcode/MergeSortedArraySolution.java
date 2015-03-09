package leetcode;

import java.util.PriorityQueue;

public class MergeSortedArraySolution {
	
    public void merge(int A[], int m, int B[], int n) {
        if(A==null || B==null || A.length==0|| B.length==0){
            return;
        }
        
        merge_helper(A,m,B,n);
        
    }
    
    public void merge_helper(int A[], int m, int B[], int n){
        
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(n);
        for(int it_B:B){
            queue.add(it_B);
        }
        
        int it_A=0;
        int temp=0;
        
        while(it_A<m){
            if(A[it_A]<=queue.peek()){
                it_A++;
            }else{
                temp=queue.poll();
                queue.add(A[it_A]);
                A[it_A]=temp;
                it_A++;
            }
        }
        
        
        for(int it=m;it<m+n;it++){
            A[it]=queue.poll();
        }
        
    }

}
