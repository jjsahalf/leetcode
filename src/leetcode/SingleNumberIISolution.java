package leetcode;

/**
 * Created by yufeijiang on 7/26/16.
 */
public class SingleNumberIISolution {
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int[] bits=new int[32];
        int result=0;
        for(int i=0; i<32; i++){
            for(int j=0; j<nums.length; j++){
                int value=nums[j];
                bits[i]+=value>>i & 1;
            }
            bits[i]=bits[i]%3;
            result+=bits[i]<<i;
        }
        return result;
    }
}
