package leetcode;

/**
 * Created by yufeijiang on 2/19/16.
 */
public class IntegerToRomanSolution {


    /*
    public class Solution {
	public String intToRoman(int num) {
		if(num <= 0) {
			return "";
		}
	    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder res = new StringBuilder();
	    int digit=0;
	    while (num > 0) {
	        int times = num / nums[digit];
	        num -= nums[digit] * times;
	        for ( ; times > 0; times--) {
	            res.append(symbols[digit]);
	        }
	        digit++;
	    }
	    return res.toString();
	}
}
     */



    public String intToRoman(int num) {
        StringBuffer sb=new StringBuffer();

        int mCounter=num/1000;
        for(int i=0;i<mCounter;i++){
            sb.append("M");
        }
        num=num%1000;
        if(num>=900){
            sb.append("CM");
            num=num-900;
        }else if(num>=500){
            sb.append("D");
            num-=500;
            if(num>=100){
                int cCounter=num/100;
                for(int i=0;i<cCounter;i++){
                    sb.append("C");
                }
            }
            num%=100;
        }else if(num>=400){
            sb.append("CD");
            num-=400;
        }else if(num>=100){
            int cCounter=num/100;
            for(int i=0;i<cCounter;i++){
                sb.append("C");
            }
            num%=100;
        }

        if(num>=90){
            sb.append("XC");
            num=num-90;
        }else if(num>=50){
            sb.append("L");
            num-=50;
            if(num>=10){
                int xCounter=num/10;
                for(int i=0;i<xCounter;i++){
                    sb.append("X");
                }
            }
            num%=10;
        }else if(num>=40){
            sb.append("XL");
            num-=40;
        }else if(num>=10){
            int xCounter=num/10;
            for(int i=0;i<xCounter;i++){
                sb.append("X");
            }
            num%=10;
        }

        if(num==9){
            sb.append("IX");
        }else if(num>=5){
            sb.append("V");
            num-=5;
            if(num>=1){
                int iCounter=num;
                for(int i=0;i<iCounter;i++){
                    sb.append("I");
                }
            }
        }else if(num==4){
            sb.append("IV");
        }else if(num>=1){
            int iCounter=num;
            for(int i=0;i<iCounter;i++){
                sb.append("I");
            }
        }

        return sb.toString();




    }
}
