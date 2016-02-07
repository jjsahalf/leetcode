package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yufeijiang on 2/6/16.
 */
public class HappyNumberSolution {
    public boolean isHappy(int n) {
        if(n<=0){
            return false;
        }
        int nextNumber=n;

        Set<Integer> set=new HashSet();
        while(nextNumber!=1){
            nextNumber=getNextNumber(nextNumber);
            if(set.contains(nextNumber)){
                return false;
            }else{
                set.add(nextNumber);
            }
        }

        return true;


    }

    protected int getNextNumber(int n){
        int sum=0;
        while(n>0){
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }
}
