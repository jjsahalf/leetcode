package leetcode;

/**
 * Created by yufeijiang on 9/28/15.
 */
public class MySqrtSolution {
    //mySqrt心得：
    //分支的选择 能用else一定要用else
    //大数的处理，危险性在于middle*middle， 临时找一个类型暂存一下
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }


        int lowerRoot=1;
        int upperRoot=x-1;
        int middleRoot=(lowerRoot+upperRoot)/2;
        while(upperRoot-lowerRoot>1){
            if(middleRoot*middleRoot==x){
                return middleRoot;
            }
            long middleInLong=middleRoot;
            long middleSquare=middleInLong*middleInLong;
            if( middleSquare>x){
                upperRoot=middleRoot;
                middleRoot=(upperRoot+lowerRoot)/2;
            }else{
                lowerRoot=middleRoot;
                middleRoot=(upperRoot+lowerRoot)/2;
            }
        }

        return lowerRoot;
    }
}
