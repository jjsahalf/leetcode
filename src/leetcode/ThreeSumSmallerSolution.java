package leetcode;

import java.util.Arrays;

/**
 * Created by yufeijiang on 9/11/16.
 */
public class ThreeSumSmallerSolution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int local = 0;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    local += right - left;
                    left++;
                } else {
                    right--;
                }
            }
            total += local;
        }
        return total;
    }
}
