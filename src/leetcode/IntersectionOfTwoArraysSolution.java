package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yufeijiang on 8/21/16.
 */
public class IntersectionOfTwoArraysSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
            return new int[0];
        }


        Set<Integer> set=new HashSet();
        Set<Integer> res=new HashSet();
        for(int i:nums1){
            set.add(i);
        }


        for(int j:nums2){
            if(set.contains(j)){
                res.add(j);
            }
        }

        int[] resArray=new int[res.size()];
        int counter=0;
        for(Integer i:res){
            resArray[counter]=i;
            counter++;
        }
        return resArray;




    }
}
