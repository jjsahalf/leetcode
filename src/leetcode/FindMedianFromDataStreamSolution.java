package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yufeijiang on 9/27/16.
 */
public class FindMedianFromDataStreamSolution {
    private PriorityQueue<Integer> pq1;
    private PriorityQueue<Integer> pq2;
    private double median;

    public FindMedianFromDataStreamSolution(){
        pq1=new PriorityQueue();
        pq2=new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
        median=0;
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(pq1.size()==0){
            pq1.add(num);
            median=num;
            return;
        }
        if(pq1.size()==pq2.size()){
            if(num>=pq2.peek()){
                pq1.add(num);
            }else{
                int temp=pq2.poll();
                pq1.add(temp);
                pq2.add(num);
            }
            median=pq1.peek();
            return;
        }
        if(pq1.size()-pq2.size()==1){
            if(num<=median){
                pq2.add(num);
            }else{
                int temp=pq1.poll();
                pq2.add(temp);
                pq1.add(num);
            }
            median = (pq1.peek()+pq2.peek())/2.0;
        }
    }

    public double findMedian() {
        return median;
    }

}
