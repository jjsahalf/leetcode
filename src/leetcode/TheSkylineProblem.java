package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 10/7/16.
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res=new ArrayList();
        List<int[]> height=new ArrayList();
        for(int[] b:buildings){
            int[] leftHeight={b[0],-b[2]};
            int[] rightHeight={b[1], b[2]};
            height.add(leftHeight);
            height.add(rightHeight);
        }
        Collections.sort(height, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1]-b[1];
                }
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        pq.add(0);
        for(int[] curr:height){
            int prevPeak=pq.peek();
            if(curr[1]<0){
                pq.offer(-curr[1]);
                int newPeak=pq.peek();
                if(newPeak!=prevPeak){
                    int[] point={curr[0], newPeak};
                    res.add(point);
                }
            }else{
                pq.remove(curr[1]);
                int newPeak=pq.peek();
                if(newPeak!=prevPeak){
                    int[] point={curr[0], newPeak};
                    res.add(point);
                }
            }
        }
        return res;
    }
}
