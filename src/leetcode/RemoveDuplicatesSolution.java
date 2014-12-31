package leetcode;

public class RemoveDuplicatesSolution {
	
	//this solution is from nine chapter
	//we only need two pointers for this.
    /*public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }*/
	
	
    public int removeDuplicates(int[] A) {
    	if(A==null || A.length==0 ){
    		return 0;
    	}
    	
    	if(A.length==1){
    		return 1;
    	}
    	
    	int it_1=0;
    	int it_2=1;
    	int it_temp=it_2;
    	
    	while(it_2<A.length){
    		//it_temp=it_2;
    		if(A[it_1]>=A[it_2]){
    			
        		while(A[it_2]>=A[it_temp]){
        			if(it_temp==A.length-1){
        				return it_1+1;
        			}else{
        				it_temp++;
        			}
        		}
        		
        		for(int shift=it_2; shift<it_temp; shift++){
        			A[shift]=A[it_temp];
        			
        		}
        		//A[it_2]=A[it_temp];
        		
        		if(it_2+1==A.length){
        			return it_1+1;
        		}else{
        			it_1++;
        			it_2++;
        			//it_temp=it_2;
        		}
        		
    		}else{
    			it_1++;
    			it_2++;
    		}

    	}
    	
    	return it_1+1;
        
    }

}
