package leetcode;

public class PalindromeSolution {
	
    public boolean isPalindrome(int x) {
    	//key point: handle the negative number case
    	if(x<0){
    		return false;
    	}
    	long x_long_permanant=x;
    	long x_long=x;
    	long sum=0;
    	while(x_long!=0){
       		sum*=10;
    		sum+=x_long%10;
    		x_long=x_long/10;
    	}
    	if(sum==x_long_permanant){
    		return true;
    	}else{
    		return false;
    	}
    	
        
    }

}
