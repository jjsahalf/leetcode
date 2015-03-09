package leetcode;

import java.util.HashSet;
import java.util.Set;

//should use hashmap
//index2 should be retrived by key-value.

public class TwoSum03072015 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res_array=new int[2];
        res_array[0]=-1;
        res_array[1]=-1;
        
        if(numbers.length==0){
            return res_array;
        }
        
        
        Set<Integer> number_set=new HashSet<Integer>();
        for(int i=0;i<numbers.length;i++){
            number_set.add(numbers[i]);
        }
        for(int i=0;i<numbers.length;i++){
            if(number_set.contains(target-numbers[i])){
                res_array[0]=i+1;
                for(int j=i+1;j<numbers.length;j++){
                    if(numbers[j]==target-numbers[i]){
                        res_array[1]=j+1;
                        return res_array;
                    }
                }
            }
        }
        
        res_array[0]=-1;
        res_array[1]=-1;
        return res_array;
        
    }
}
