package leetcode;

public class atoiSolution {
	
    public int atoi(String str) {
        
        if(str==null || str.equals("")){
            System.out.println("null input");
            return 0;
        }
        
        str=str.trim();
        int sign;
        char first_char=str.charAt(0);
        if(first_char=='+'){
            sign=1;
            str=str.substring(1,str.length());
        }else if(first_char=='-'){
            sign=-1;
            str=str.substring(1,str.length());
        }else if(first_char>='0'&& first_char<='9'){
            sign=1;
        }else{
            System.out.println("null input");
            return 0;
        }
        
        char current_char;
        long long_sum=0;
        for(int i=0;i<str.length();i++){
            current_char=str.charAt(i);
            if(current_char>='0' && current_char<='9'){
                int value=(int)current_char-'0';
                long_sum=long_sum*10;
                long_sum+=value;
                if(sign==1 && long_sum>=Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(sign==-1 && long_sum>Integer.MAX_VALUE){
                    return Integer.MIN_VALUE;
                }
                
            }else{
                break;
            }
        }
        
        int sum=(int)long_sum;
        
        return sum*sign;
        
    }
    
    public int checksign(String str){
        int sign=0;
        char first=str.charAt(0);
        if(first=='+' || (first>='0'&& first<='9')){
            sign=1;
            return sign;
        }
        if(first=='-'){
            sign=-1;
            return sign;
        }
        return sign;
        
    }

}
