package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yufeijiang on 9/10/16.
 */


class IntervalIII {
    int start;
    int end;
    IntervalIII() { start = 0; end = 0; }
    IntervalIII(int s, int e) { start = s; end = e; }
}

public class MeetingRoomsIISolution {
    public int minMeetingRooms(IntervalIII[] intervals) {
        if(intervals==null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<IntervalIII>(){
            public int compare(IntervalIII i1, IntervalIII i2){
                return i1.start-i2.start;
            }
        });
        List<Integer> start=new ArrayList();
        for(IntervalIII i:intervals){
            start.add(i.start);
        }
        Arrays.sort(intervals, new Comparator<IntervalIII>(){
            public int compare(IntervalIII i1, IntervalIII i2){
                return i1.end-i2.end;
            }
        });
        List<Integer> end=new ArrayList();
        for(IntervalIII i:intervals){
            end.add(i.end);
        }
        int startIndex=0;
        int endIndex=0;
        int counter=0;
        int max=0;
        while(startIndex<start.size()){
            if(start.get(startIndex)<end.get(endIndex)){
                counter++;
                startIndex++;
            }else{
                counter--;
                endIndex++;
            }
            max=Math.max(counter,max);
        }
        return max;
    }
}
