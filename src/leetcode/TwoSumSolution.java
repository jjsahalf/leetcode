package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumSolution {
	
	private Set<Integer> duplicate_set=new HashSet<Integer>();
	private List<Integer> duplicate_list=new ArrayList<Integer>();

	
    public int[] twoSum(int[] numbers, int target) {
    	//not necessary for leetcode
    	//necessary for actual case
    	if(numbers == null || numbers.length < 2) {
    		return null;
    	}
    	
        int[] indeces=new int[2];
        
        for(int i:numbers){
        	duplicate_set.add(i);
        	duplicate_list.add(i);
        }
        
        int diff;
        int counter=1;
        int smaller_index;
        int bigger_index;
        //we must exclude the case that itself+itself=target
        //question requires two different numbers;
        //use traditional for loop is better which can 
        //save an array list
        for(int iterator:numbers){
        	diff=target-iterator;
        	if(duplicate_set.contains(diff)){
        		smaller_index=counter;
        		bigger_index=duplicate_list.indexOf(diff)+1;
        		if(!(smaller_index==bigger_index)){
            		indeces[0]=Math.min(smaller_index, bigger_index);
            		indeces[1]=Math.max(smaller_index, bigger_index);
            		return indeces;
        		}

        	}
        	counter++;
        }
        
        
        return null;
    }

}
