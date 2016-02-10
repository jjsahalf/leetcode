package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 2/10/16.
 */
public class SummaryRangesSolution {

    /*
    CHECK IF I NUMBER EQUAL TO NUMS.LENGTH THEN DO SOME PROCESSING, MIGHT BE A BETTER IDEA.
    public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<String>();

    if(nums == null || nums.length==0)
        return result;

    if(nums.length==1){
        result.add(nums[0]+"");
    }

    int pre = nums[0]; // previous element
    int first = pre; // first element of each range

    for(int i=1; i<nums.length; i++){
            if(nums[i]==pre+1){
                if(i==nums.length-1){
                    result.add(first+"->"+nums[i]);
                }
            }else{
                if(first == pre){
                    result.add(first+"");
                }else{
                    result.add(first + "->"+pre);
                }

                if(i==nums.length-1){
                    result.add(nums[i]+"");
                }

                first = nums[i];
            }

            pre = nums[i];
    }

    return result;
}
     */





    public List<String> summaryRanges(int[] nums) {
        if(nums==null){
            return null;
        }

        List<String> list=new ArrayList();
        if(nums.length==0){
            return list;
        }
        boolean newRanges=true;
        int i=0;
        int counter=0;
        Integer beginValue=0;
        StringBuffer sb=new StringBuffer();
        while(i<nums.length){
            if(newRanges){
                sb=new StringBuffer();
                beginValue=nums[i];
                sb.append(beginValue.toString());
                counter=beginValue;
                counter++;
                newRanges=false;
                i++;
            }else{
                if(counter==nums[i]){
                    counter++;
                    i++;
                }else{
                    counter--;
                    Integer endNumber=counter;
                    if(endNumber.equals(beginValue)){
                        list.add(sb.toString());
                        newRanges=true;
                    }else{
                        sb.append("->");
                        sb.append(endNumber.toString());
                        list.add(sb.toString());
                        newRanges=true;
                    }
                }
            }
        }

        if(newRanges==false){
            if(beginValue==nums[nums.length-1]){
                list.add(beginValue.toString());
            }else{
                Integer end=nums[nums.length-1];
                list.add(beginValue.toString()+"->"+end.toString());
            }
        }

        return list;
    }
}
