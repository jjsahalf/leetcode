package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yufeijiang on 2/1/16.
 */
public class PascalTriangleIISolution {
    public List<Integer> getRow(int rowIndex) {
        Queue<Integer> queue=new LinkedList();

        if(rowIndex<0){
            return (List)queue;
        }


        queue.add(1);


        for(int i=0; i<rowIndex;i++){
            int currentQueueSize=queue.size();
            for(int j=-1; j<currentQueueSize; j++){
                if(j==-1){
                    queue.add(queue.peek());
                    continue;
                }
                if(j==currentQueueSize-1){
                    queue.add(queue.poll());
                    continue;
                }

                queue.add(queue.poll()+queue.peek());

            }
        }

        return (List)queue;

    }


}
