package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 10/4/16.
 */
public class MaximumSizeSubarraySumEqualskSolution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
`