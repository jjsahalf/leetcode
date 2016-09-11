package leetcode;

/**
 * Created by yufeijiang on 9/11/16.
 */
public class SingleNumberIIISolution {
    public int[] singleNumber(int[] nums) {
        int totalXOR=0;
        for(int i=0;i<nums.length;i++){
            totalXOR^=nums[i];
        }
        int mask=1;
        while((totalXOR & mask) ==0 ){
            mask=mask<<1;
        }
        int single1=0;
        int single2=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & mask)==0){
                single1 ^= nums[i];
            }else{
                single2 ^= nums[i];
            }
        }
        int[] res =new int[2];
        res[0]=single1;
        res[1]=single2;
        return res;
    }
}
