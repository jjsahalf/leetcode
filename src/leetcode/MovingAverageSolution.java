package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yufeijiang on 10/13/16.
 */
public class MovingAverageSolution {

    private Queue<Integer> queue;
    private int size;
    private double currSum;

    /** Initialize your data structure here. */
    public MovingAverageSolution(int size) {
        queue=new LinkedList();
        this.size=size;
        this.currSum=0;
    }

    public double next(int val) {
        int outNumber=0;
        if(queue.size()==size){
            outNumber=queue.poll();
        }
        queue.offer(val);
        currSum=currSum+val-outNumber;
        return currSum/queue.size();
    }
}
