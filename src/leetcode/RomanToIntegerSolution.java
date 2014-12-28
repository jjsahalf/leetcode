package leetcode;

public class RomanToIntegerSolution {
	
	//nine chapter algorithm
/*	
    if (s == null || s.length()==0) {
return 0;
    }
    
    //Use Hashmap rather than switch
    Map<Character, Integer> m = new HashMap<Character, Integer>();
    m.put('I', 1);
    m.put('V', 5);
    m.put('X', 10);
    m.put('L', 50);
    m.put('C', 100);
    m.put('D', 500);
    m.put('M', 1000);

    int length = s.length();
    
    //reverse order
    //plus bigger or the same number
    //minus smaller number
    int result = m.get(s.charAt(length - 1));
    for (int i = length - 2; i >= 0; i--) {
        if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
            result += m.get(s.charAt(i));
        } else {
            result -= m.get(s.charAt(i));
        }
    }
    return result;*/
	
	//the key point is to understand what is Roman numeral
    public int romanToInt(String s) {
    	if(s==null||s.equals("")){
    		return -1;
    	}
    	
    	char before_char='a';
    	char current_char='a';
    	String valid_string="a";
    	int current_int=0;
    	int sum=0;;
    	
    	for(int i=0;i<s.length();i++){
    		
    		
    		//sum*=10;
    		current_char=s.charAt(i);
    		switch(current_char){
    		case 'M':current_int=1000;
    		break;
    		case 'D':
    			current_int=500;
    		break;
    		case 'C':
    		if(i<s.length()-1 && s.charAt(i+1)=='D'){
    			i++;
    			current_int=400;
    		}else if(i<s.length()-1 && s.charAt(i+1)=='M'){
    			i++;
    			current_int=900;
    		}else{
    			current_int=100;
    		}
    		break;
    		case 'L':current_int=50;
    		break;
    		case 'X':
    		if(i<s.length()-1 && s.charAt(i+1)=='C'){
    			i++;
    			current_int=90;
    		}else if(i<s.length()-1 && s.charAt(i+1)=='L'){
    			i++;
    			current_int=40;
    		}else{
    			current_int=10;
    		}
    		break;
    		case 'V':current_int=5;
    		break;
    		case 'I':
    	   		if(i<s.length()-1 && s.charAt(i+1)=='X'){
        			i++;
        			current_int=9;
        		}else if(i<s.length()-1 && s.charAt(i+1)=='V'){
        			i++;
        			current_int=4;
        		}else{
        			current_int=1;
        		}
    		break;
    		}
    		sum+=current_int;
    		
    		
    	}
    	
        return sum;
    }

}
