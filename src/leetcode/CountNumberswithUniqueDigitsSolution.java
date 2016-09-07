package leetcode;

/**
 * Created by yufeijiang on 9/7/16.
 */
public class CountNumberswithUniqueDigitsSolution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n<0){
            return -1;
        }
        if(n==0){
            return 1;
        }
        int sum=10;
        for(int i=2;i<=n;i++){
            int local=9;
            int last=9-i+2;
            for(int num=9;num>=last;num--){
                local*=num;
            }
            sum+=local;

        }
        return sum;
    }
}
