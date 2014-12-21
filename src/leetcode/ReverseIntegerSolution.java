package leetcode;
//nine chapter algorithm
//this one is good, no need to handle negative number and import string
/*public int reverse(int x) {
    int rst = 0;
    while(x != 0){
        rst = rst * 10 + x % 10;
        x = x / 10;
    }
    return rst;
}*/
public class ReverseIntegerSolution {
	//1. Handle the negative number
	//2. use long rather than int, thus we can handle the large number
    public int reverse(int x) {
		long x_long=x;
		
    	if(x_long<0){
    		x_long=x_long*(-1);
    	}
    	Long i=x_long;
    	String i_string=i.toString();
    	long l=0;
    	char current_number;
    	long current_integer;
    	long sum=0;
    	for(int index=0;index<i_string.length();index++){
    		current_number=i_string.charAt(index);
    		String s_n=new StringBuffer().append(current_number).toString();
    		current_integer=Long.parseLong(s_n);
    		sum+=current_integer*Math.pow(10, index);
    	}
    	//i_string.charAt(arg0) 
    	//while(){
    		
    	//}
    	int res=0;
    	if(sum>Integer.MAX_VALUE){
    		return 0;
    	}
    	if(sum<Integer.MIN_VALUE){
    		return 0;
    	}
    	res=(int) sum;
    	if(x<0){
    		return res*(-1);
    	}else{
    		return res;
    	}
    	
    }
}
