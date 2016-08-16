package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 8/16/16.
 */
public class MissingRangesSolution {

    /*
    用getRange这个函数来把数字转成string稍微简介一点。不用重复代码
    public List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> ranges = new ArrayList<String>();
        int prev = start - 1;
        for (int i=0; i<=vals.length; ++i) {
            int curr = (i==vals.length) ? end + 1 : vals[i];
            if ( cur-prev>=2 ) {
                ranges.add(getRange(prev+1, curr-1));
            }
            prev = curr;
        }
        return ranges;
    }

    private String getRange(int from, int to) {
        return (from==to) ? String.valueOf(from) : from + "->" + to;
    }
     */



    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list=new ArrayList();
        int left=lower;
        int right=upper;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==left){
                left++;
                continue;
            }else{
                int middleLeft=nums[i]-1;
                int middleRight=nums[i]+1;
                if(middleLeft==left){
                    list.add(new Integer(left).toString());
                }else{
                    StringBuilder sb=new StringBuilder(new Integer(left).toString());
                    sb.append("->");
                    sb.append(new Integer(middleLeft).toString());
                    list.add(sb.toString());
                }
                left=middleRight;
            }
        }
        if(left<upper){
            StringBuilder sb=new StringBuilder(new Integer(left).toString());
            sb.append("->");
            sb.append(new Integer(upper).toString());
            list.add(sb.toString());
        }else if(left==upper){
            list.add(new Integer(left).toString());
        }

        return list;
    }

}
