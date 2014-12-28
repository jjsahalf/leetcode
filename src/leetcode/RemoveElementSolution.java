package leetcode;

public class RemoveElementSolution {
	//use two pointers
	
	//nine chapter algorithm
    /*int i = 0;
    int pointer = A.length - 1;
    while(i <= pointer){
        if(A[i] == elem){
            A[i] = A[pointer];
            pointer--;
        } else {
            i++;
        }
    }
    return pointer + 1;*/
	
    public int removeElement(int[] A, int elem) {
    	int length=A.length;
    	int end=length;
    	
    	if(A==null || A.length==0){
    		return 0;
    	}
    	
    	for(int i=0;i<end;i++){
    		if(A[i]==elem){
    			while(end>i){
    				//note: it is note-1
    				if(A[end-1]!=elem){
    					A[i]=A[end-1];
    					end--;
    					break;
    				}
    				end--;
    			}
    		}
    	}
        return end;
    }

}
