package leetcode;

import java.math.BigDecimal;

public class FractionToRecurringDecimalTest {

	public static void main(String[] args) {
		FractionToRecurringDecimalSolution f_instance=new FractionToRecurringDecimalSolution();
		System.out.println(f_instance.fractionToDecimal(-1, -2147483648));
		long a=-1;
		long b=-2147483648;
		long p=a*b;
		System.out.println(p);
		System.out.println(1d/19d);
		
		/*Double double_number=1d/3d;
		System.out.println(double_number);
		Float float_number=1f/7f;
		System.out.println(float_number);
		if(double_number.equals(float_number)){
			System.out.println("o");
		}else{
			System.out.println("yay");
		}
		//Float float_number=1/7;
		BigDecimal bd1=new BigDecimal(1d);
		BigDecimal bd2=new BigDecimal(7d);
		System.out.println(bd1.divide(bd2));
		//System.out.println(bd1/bd2);*/
				
	}

}
