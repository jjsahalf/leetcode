package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yufeijiang on 10/13/16.
 */
public class SlidingWindowMaximumSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }
}
