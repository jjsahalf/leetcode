package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yufeijiang on 2/9/16.
 */
public class ContainsDuplicateIISolution {


    /*
THIS ONE IS BETTER, NO NEED TO USE LIST, JUST USE THE LATEST INDEX
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for(int i=0; i<nums.length; i++){
        if(map.containsKey(nums[i])){
            int pre = map.get(nums[i]);
            if(i-pre<=k)
                return true;
        }

        map.put(nums[i], i);
    }

    return false;
}


     */



    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null){
            return false;
        }
        if(nums.length==0){
            return false;
        }

        Map<Integer, List<Integer>> map=new HashMap();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> indexValueList=map.get(nums[i]);
                for(Integer each:indexValueList){
                    if(Math.abs(each-i)<=k){
                        return true;
                    }
                }
                indexValueList.add(i);
            }else{
                List<Integer> list=new ArrayList();
                list.add(i);
                map.put(nums[i],list);
            }
        }

        return false;


    }
}
