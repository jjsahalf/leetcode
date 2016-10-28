package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yufeijiang on 10/27/16.
 */
public class BinaryWatchSolution {
    public List<String> readBinaryWatch(int num) {
        List<String> list=new ArrayList();
        if(num<0 || num>8){
            return list;
        }
        int[] hrs={1,2,4,8};
        int[] minutes={1,2,4,8,16,32};
        for(int i=0; i<=num; i++){
            int hrLight=i;
            int minuteLight=num-i;
            if(hrLight<=4 && minuteLight<=6 ){
                List<String> hrList=new ArrayList();
                dfs(hrLight, 0, hrList, hrs,0);
                List<String> minuteList=new ArrayList();
                dfs(minuteLight, 0, minuteList, minutes, 0);
                for(String hrStr:hrList){
                    for(String minuteStr:minuteList){
                        if(Integer.parseInt(hrStr)>=12 || Integer.parseInt(minuteStr)>=60){
                            continue;
                        }
                        String adjustedMinuteStr=minuteStr;
                        if(Integer.parseInt(minuteStr)<10){
                            adjustedMinuteStr="0"+adjustedMinuteStr;
                        }
                        list.add(hrStr+":"+adjustedMinuteStr);
                    }
                }
            }
        }
        Collections.sort(list);
        return list;
    }
    public void dfs(int num, int start, List<String> list, int[] array, Integer sum){
        if(num==0){
            list.add(sum.toString());
        }
        for(int i=start; i<array.length; i++){
            sum+=array[i];
            dfs(num-1, i+1, list, array, sum);
            sum-=array[i];
        }
    }
}
