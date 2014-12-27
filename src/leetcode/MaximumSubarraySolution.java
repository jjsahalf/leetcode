package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarraySolution {
	//such a subarray must not start with or end with a
	//negagtive number
	
	//the case of all negative number
	//the case of ending in section 1
	
	//this algorithm is from ninechapter 
    public int maxSubArray(int[] A) {
    	if(A==null || A.length==0){
    		return -1;
    	}
    	
    	int max=Integer.MIN_VALUE;
    	int sum=0;
    	for(int i=0;i<A.length;i++){
    		sum+=A[i];
    		max=Math.max(sum, max);
    		
    		//the key point is here
    		sum=Math.max(sum, 0);
    	}
    	return max;
    	
/*    	int section_1_positive=0;
    	int section_2_negative=0;
    	int section_3_positive=0;
    	int max_single_section=A[0];
    	int section_sum=0;
    	
    	String status="unknown";
    	
    	if(A==null || A.length==0){
    		return -1;
    	}
    	
    	for(int index=0;index<A.length;index++){
    		if(status.equals("unknown")){
    			if(A[index]<0){
    				//the case that all number are negative;
    				max_single_section=Math.max(max_single_section, A[index]);
    			}else{
    				status="section1";
    				section_1_positive+=A[index];
    				continue;
    			}
    		}
    		if(status.equals("section1")){
    			if(A[index]<0){
    				status="section2";
    				section_2_negative+=A[index];
    				max_single_section=Math.max(section_1_positive, max_single_section);
    				continue;
    			}else{
    				section_1_positive+=A[index];
    			}
    		}
    		
    		if(status.equals("section2")){
    			if(A[index]<0){
    				section_2_negative+=A[index];
    			}else{
    				status="section3";
    				section_3_positive+=A[index];
    				continue;
    				
    			}
    		}
    		
    		if(status.equals("section3")){
    			if(A[index]<0){
    				max_single_section=Math.max(max_single_section, section_3_positive);
    				section_sum=section_1_positive+section_2_negative+section_3_positive;
    				if(section_sum>=section_1_positive && section_sum>=section_3_positive){
      					max_single_section=Math.max(section_sum, max_single_section);
    					section_1_positive=section_sum;
    					section_2_negative=A[index];
    					section_3_positive=0;
  
    					status="section2";
    					continue;
    				}
    				if(section_3_positive>=section_1_positive && section_3_positive>section_sum){
    					max_single_section=Math.max(section_3_positive, max_single_section);
    					section_1_positive=section_3_positive;
    					section_2_negative=A[index];
    					section_3_positive=0;
    					
    					status="section2";
    					continue;
    				}
    				if(section_1_positive>section_3_positive && section_1_positive>section_sum){
    					max_single_section=Math.max(section_1_positive, max_single_section);
    					//max_sub_array(A[index]);
    					section_2_negative+=A[index];
    					section_3_positive=0;
    					
    					status="section2";
    					continue;
    				}
    				
    			}else{
    				section_3_positive+=A[index];
    			}
    		}
    		
    	}
    	
    	if(status.equals("unknown")){
    		return max_single_section;
    	}
    	
    	section_sum=section_1_positive+section_2_negative+section_3_positive;
    	int max_of_three=Math.max(section_1_positive, Math.max(section_3_positive, section_sum));
    	max_single_section=Math.max(max_of_three, max_single_section);
    	return max_single_section;*/
    	
/*    	int maximum_sum=0;
    	int positive_section=0;
    	int negative_section=0;
    	//int max_single_section=0;
    	String status="unknown";
    	List sub_list=new ArrayList();
    	int first_negative=0;
    	int sum=0;
    	int section_sum=0;
    	
    	for(int index=0;index<A.length;index++){
    		if (status.equals("unknown")) {
				if (A[index] < 0) {
					negative_section += A[index];
					status="negative";
				} else {
					positive_section += A[index];
					status="positive";
				}
			}
    		
    		if(status.equals("positive")){
    			if(A[index]<0){
    				maximum_sum=Math.max(positive_section,maximum_sum);
    				negative_section+=A[index];
    				status="negative";
    			}else{
    				positive_section+=A[index];
    			}	
    		}
    		
    		if(status.equals("negative")){
    			if(A[index]<0){
    				negative_section+=A[index];
    			}else{
    				status="positive";
    				if(positive_section>=Math.abs(negative_section)){
    					positive_section=positive_section-Math.abs(negative_section);
    					positive_section+=A[index];
    				}else{
    					positive_section=A[index];
    					negative_section=0;
    					
    				}
    			}
    		}    		
    	}
        return 0;*/
    }

}
