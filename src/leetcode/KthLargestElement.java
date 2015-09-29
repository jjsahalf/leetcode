package leetcode;

import java.util.PriorityQueue;

/**
 * Created by yufeijiang on 9/28/15.
 */
public class KthLargestElement {

    //不需要传入Comparator, 因为这里用到的是最小堆
    //传入的k值只是initial capacity 之后还要自己管理
    public int findKthLargest(int[] nums, int k){

        PriorityQueue<Integer> pq=new PriorityQueue(k);


        for(int i=0;i<nums.length;i++){
            if(i<k){
                pq.offer(nums[i]);
            }else{
                int temp=pq.peek();
                if(nums[i]>temp){
                    pq.remove();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
