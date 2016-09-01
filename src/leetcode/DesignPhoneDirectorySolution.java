package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by yufeijiang on 9/1/16.
 */
public class DesignPhoneDirectorySolution {

    private PriorityQueue<Integer> pq;
    private Set<Integer> set;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectorySolution(int maxNumbers) {
        this.pq=new PriorityQueue(maxNumbers);
        for(int i=0; i<maxNumbers;i++){
            this.pq.offer(i);
        }
        this.set=new HashSet();
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(pq.size()!=0){
            int number= pq.poll();
            set.add(number);
            return number;
        }else{
            return -1;
        }


    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(set.contains(number)){
            pq.offer(number);
            set.remove(number);
        }
    }
}
