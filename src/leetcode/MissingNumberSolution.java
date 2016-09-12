package leetcode;

/**
 * Created by yufeijiang on 9/12/16.
 */
public class MissingNumberSolution {
    public int missingNumber(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int[] bits=new int[32];
        int[] totalBits=new int[32];
        for(int i=0; i<nums.length;i++){
            int mask=1;
            for(int j=0; j<32;j++){
                int shift=nums[i]>>j;
                int curr=shift & mask;
                bits[j]+=curr;
            }
        }
        for(int i=0;i<nums.length+1;i++){
            int mask=1;
            for(int j=0;j<32;j++){
                int shfit=i>>j;
                int curr=shfit & mask;
                totalBits[j]+=curr;
            }
        }
        int res=0;
        for(int i=0; i<32; i++){
            int bit=totalBits[i]-bits[i];
            bit=bit<<i;
            res = res | bit;
        }
        return res;
    }
}
