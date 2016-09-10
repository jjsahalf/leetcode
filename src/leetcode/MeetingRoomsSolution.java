package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yufeijiang on 9/10/16.
 */

class IntervalII {
    int start;
    int end;
    IntervalII() { start = 0; end = 0; }
    IntervalII(int s, int e) { start = s; end = e; }
}

class IntervalComparator implements Comparator<IntervalII> {
    public int compare(IntervalII i1, IntervalII i2){
        return i1.start-i2.start;
    }
}

public class MeetingRoomsSolution {
    public boolean canAttendMeetings(IntervalII[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, new IntervalComparator());


        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}
