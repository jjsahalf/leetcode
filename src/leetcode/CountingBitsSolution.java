package leetcode;

/**
 * Created by yufeijiang on 8/29/16.
 */
public class CountingBitsSolution {
    public int[] countBits(int num) {
        int[] array=new int[num+1];
        array[0]=0;
        if(num==0){
            return array;
        }
        array[1]=1;
        if(num==1){
            return array;
        }
        int powerOfTwo=2;
        int i=2;
        while(i<=num){
            int currentGap=0;
            if(i==powerOfTwo){
                currentGap=powerOfTwo;
                powerOfTwo*=2;
            }
            while(i<=num && i<powerOfTwo){
                array[i]=array[i-currentGap]+1;;
                i++;
            }
        }
        return array;
    }
}
