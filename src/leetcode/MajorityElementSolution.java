package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yufeijiang on 2/3/16.
 */
public class MajorityElementSolution {

    /*
    THIS ONE IS INTERESTING

     * @param nums: a list of integers
     * @return: find a  majority number

    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 0, candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
     */




    public int majorityElement(int[] nums) {

        Map<Integer, Integer> hashMap=new HashMap();

        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], hashMap.get(nums[i])+1);
            }else{
                hashMap.put(nums[i],1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet=hashMap.entrySet();

        int majorElement=-1;
        for(Map.Entry<Integer, Integer> entry:entrySet){
            int bar=nums.length/2;
            if(entry.getValue()>bar){
                majorElement=entry.getKey();
                return majorElement;
            }
        }

        return majorElement;

    }
}
