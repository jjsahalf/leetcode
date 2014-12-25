package leetcode;

import java.util.HashSet;
import java.util.Set;


public class SingleNumberSolution {
	//use hashset is not OK in this question
	//because use extra space
	//XOR operator is interesting.
    public int singleNumber(int[] A) {

    	if(A.length==0||A==null){
    		return -1;
    	}
    	int res=0;
    	for(int i=0;i<A.length;i++){
    		//this is the key point
    		res=res^A[i];
    	}
    	
    	return res;
    }
}
