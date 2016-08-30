package leetcode;

/**
 * Created by yufeijiang on 8/29/16.
 */
public class PowerOfFourSolution {
    public boolean isPowerOfFour(int num) {
        int counter=0;
        int pos=0;
        for(int i=0;i<32;i++){
            int shift=num>>i;
            int res=1 & shift;
            if(res==1){
                counter++;
                if(counter>=2){
                    return false;
                }
                pos=i;
            }
        }
        if(counter==1 && (pos%2==0)){
            return true;
        }else{
            return false;
        }
    }
}
