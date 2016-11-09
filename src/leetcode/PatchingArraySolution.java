package leetcode;

/**
 * Created by yufeijiang on 11/8/16.
 */
public class PatchingArraySolution {
    public int minPatches(int[] nums, int n) {
        if(n<=0){
            return -1;
        }
        long firstMissing=1;
        int patching=0;
        int index=0;
        while(firstMissing<=n){
            if(index<nums.length && nums[index]<=firstMissing){
                firstMissing+=nums[index];
                index++;
            }else{
                patching++;
                firstMissing*=2;
            }
        }
        return patching;
    }
}
