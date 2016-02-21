package leetcode;

/**
 * Created by yufeijiang on 2/21/16.
 */
public class DivideTwoIntegersSolution {

    /*
    1. 二分查找
    2. 涉及到边界,用long
    3. Integer.MAX_VALUE, Integer.MIN_VALUE
     */

    public int divide(int dividend, int divisor) {
        //dividend/divisor
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        if(dividend==0){
            return 0;
        }

        if(divisor==1){
            return dividend;
        }

        int sign=1;
        if(dividend>0 && divisor<0 || dividend<0 && divisor>0){
            sign=-1;
            divisor*=sign;
        }


        long dd=dividend;
        long dr=divisor;
        dd=Math.abs(dd);
        dr=Math.abs(dr);

        long result=0;
        long sum=dr;
        long counter=1;

        while(dd>=dr){
            counter=1;
            while((sum+sum)<dd){
                sum+=sum;
                counter+=counter;
            }
            result+=counter;
            dd-=sum;
            sum=dr;
        }


        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int)result*sign;


    }
}
