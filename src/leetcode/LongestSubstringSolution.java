package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//if your want to search anything, use hash set!!!
//every character needs a search
//when there is repeating, removal happends, only several cases
//index only goes one round.
public class LongestSubstringSolution {
	
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        int max_length=0;
        Set slicing_set=new HashSet();
        if(s==null || s.equals("")){
        	return max_length;
        }
        int string_size=s.length();
        char current_char;
        int index=0;
        for(int i=0;i<string_size;i++){
        	current_char=s.charAt(i);
        	if(slicing_set.contains(current_char)){
        		
        		while(s.charAt(index)!=current_char){
        			slicing_set.remove(s.charAt(index));	
        			index++;
        		}
        		//the key point
        		//prone to error
        		index++;
        		length=slicing_set.size();
        	}else{
        		slicing_set.add(current_char);
        		length++;
        		max_length=Math.max(max_length, length);
        	}        	
        }
        
        
        return max_length;
    }

}
