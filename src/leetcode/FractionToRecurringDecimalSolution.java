package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FractionToRecurringDecimalSolution {
	public List<Long> res_list=new ArrayList<Long>();
	public List<Long> remainder_list=new ArrayList<Long>();
	private int DOUBLE_LENGTH;
	private int shift;
	private int knot_length;
	
    public String fractionToDecimal(int numerator, int denominator) {
    	//handle the the .0 case
    	//remainder_list=
    	long long_numerator=numerator;
    	long long_denominator=denominator;
    	
    	
    	boolean same_sign=true;
    	
    	long product=long_numerator*long_denominator;
    	if(product>=0){
    		same_sign=true;
    		if(long_numerator<0){
    			long_numerator*=-1;
    		}
    		if(long_denominator<0){
    			long_denominator*=-1;
    		}
    	}else{
    		same_sign=false;
    		if(long_numerator<0){
    			long_numerator*=-1;
    		}
    		if(long_denominator<0){
    			long_denominator*=-1;
    		}
    	}
    	
    	long remainder=long_numerator%long_denominator;
    	
    	double double_up=long_numerator;
    	double double_down=long_denominator;
    	double result=double_up/double_down;
    	String full_number=new Double(result).toString();
    	String[] number_array=full_number.split("\\.");
    	String fraction_part=number_array[1];
    	int fraction_length=fraction_part.length();
    	if(remainder==0){
    		if (same_sign) {
				//handle the the .0 case
				return new Long(long_numerator / long_denominator).toString();
			}else{
				StringBuffer a_buffer=new StringBuffer();
				a_buffer.append("-");
				a_buffer.append(new Long(long_numerator / long_denominator).toString());
				return a_buffer.toString();
			}

    	}else{
    		
    		//limited fraction case handler
    		//if((denominator%2==0) || (denominator%5==0)){
    		//	return full_number;
    		//}
    		long res=long_numerator/long_denominator;
    		
    		remainder=remainder*10;
    		check_repeating(remainder, long_denominator);
    		//handle the no-repeating case
    		if(shift==-1){
    			StringBuffer s_buffer=new StringBuffer();
    			s_buffer.append(long_numerator/long_denominator);
    			long remain=long_numerator%long_denominator;
    			s_buffer.append(".");
    			s_buffer.append(manual_devide(remain*10,long_denominator));
    			
    			full_number=s_buffer.toString();
    			
    			/*if(full_number.contains("E")){
    				String[] e_array=full_number.split("E");
    				int zero_number=Integer.parseInt(e_array[1]);
    				String[] dot_array=e_array[0].split("\\.");
    				StringBuffer zero_buffer=new StringBuffer();
    				zero_buffer.append("0.");
    				for(int z=0;z<zero_number-1;z++){
    					zero_buffer.append("0");
    				}
    				zero_buffer.append(dot_array[0]);
    				//for(int d=0;d<dot_array[1].length();d++){
    				zero_buffer.append(dot_array[1]);
    				
    				return full_number=zero_buffer.toString();
    				
   
    			}*/
    			
    			if (same_sign) {
					return full_number;
				}else{
					StringBuffer b_buffer=new StringBuffer();
					b_buffer.append("-");
					b_buffer.append(full_number);
					return b_buffer.toString();
				}
    		}
    		
    		String before_knot=fraction_part.substring(0, shift);
    		StringBuffer build_buffer=new StringBuffer();
    		for(int counter=0; counter<res_list.size();counter++){
    			build_buffer.append(res_list.get(counter));
    		}
    		String long_fraction=build_buffer.toString();
    		String knot=long_fraction.substring(shift, knot_length+shift);
    		
    		StringBuffer res_buffer=new StringBuffer();
			res_buffer.append(long_numerator/long_denominator+".");
			res_buffer.append(before_knot);
			res_buffer.append("("+knot+")");
    		//res_buffer.append(check_recur(numerator,denominator,fraction_part));
			
    		if (same_sign) {
				return res_buffer.toString();
			}else{
				StringBuffer n_buffer=new StringBuffer();
				n_buffer.append("-");
				n_buffer.append(res_buffer.toString());
				return n_buffer.toString();
			}
 
    	}
    	
        //return "-1";

    }
    
    public String manual_devide(long numerator, long denominator){
    	StringBuffer res_buffer=new StringBuffer();
    	res_buffer.append(numerator/denominator);
    	long remainder=numerator%denominator;
    	if(remainder==0){
    		return res_buffer.toString();
    	}else{
    		return res_buffer.append(manual_devide(remainder*10,denominator)).toString();
    	}
    	//return "-11";
    	//res_buffer.append(".");
    	
    }
    
    public void check_repeating(long numerator, long denominator){
		// int after_the_point=-1;
		/*
		 * while(numerator<denominator){ numerator=numerator*10;
		 * res_list.add(0); }
		 */
		long remainder = numerator % denominator;
		long res = numerator / denominator;
		if (remainder == 0) { // no repeating
			shift = -1;
		} else {
			
			if (!(remainder_list.contains(remainder) && res_list.contains(res))) {
				res_list.add(res);
				remainder_list.add(remainder);
				remainder = remainder * 10;
				check_repeating(remainder, denominator);
			} else {
				shift = res_list.indexOf(res);
				knot_length = res_list.size() - shift;

				// int length=remainder_list.size();
			}
		}
		// return -1;
	}



/*	public String check_recur(int numerator, int denominator,
			String fraction_part) {

		if (fraction_part.length() == 0) {
			return "";
		}

		DOUBLE_LENGTH = fraction_part.length();
		char[] single_number_array = new char[DOUBLE_LENGTH];

		for (int i = 0; i < DOUBLE_LENGTH; i++) {
			single_number_array[i] = '0';
		}
		
		System.out.println(fraction_part.length());
		for(int j=0;j<fraction_part.length();j++){
			single_number_array[j]=fraction_part.charAt(j);
			
		}
		
		StringBuffer sb=new StringBuffer();
		for(int sb_index=0;sb_index<DOUBLE_LENGTH;sb_index++){
			sb.append(single_number_array[sb_index]);
		}
		String full_length_string=sb.toString();
		
		//System.out.println("this is a String "+single_number_array.);
		
		boolean is_recur=false;
		for(int knot_length=1;knot_length<=(DOUBLE_LENGTH/2);knot_length++){
	
			
			String knot=full_length_string.substring(0, knot_length);
			System.out.println("knot: "+knot);
			int rounds=DOUBLE_LENGTH/knot_length;
			for(int r=1;r<rounds;r++){
				System.out.println("compare: "+full_length_string.substring(r*knot_length, 
						r*knot_length+knot_length));
				if(knot.equals(full_length_string.substring(r*knot_length, 
						r*knot_length+knot_length))){
					is_recur=true;
				}else{
					is_recur=false;
					break;
				}
			}
			if(is_recur){
				StringBuffer res_buffer=new StringBuffer();

				res_buffer.append("("+knot+")");
				return res_buffer.toString();
			}
		}
		
		StringBuffer no_recur_buffer=new StringBuffer();
		no_recur_buffer.append(fraction_part.charAt(0));
		no_recur_buffer.append(check_recur(numerator,denominator,fraction_part.substring(1)));
		return no_recur_buffer.toString();
    }*/

}
