package leetcode;

public class PowSolution {
	
    public double pow(double x, int n) {     
        if(n==0){
            return 1.0;
        }
        if(n==1){
            return x;
        }
        boolean is_negative=false;
        if(n<0){
            n=n*(-1);
            is_negative=true;
        }
        double half=pow(x,n/2);
        double res;
        if(n%2==0){
            res= half*half;
        }else{
            res= half*half*x;
        }
        if(is_negative){
            res=1/res;
        }
        return res;
    }
}
