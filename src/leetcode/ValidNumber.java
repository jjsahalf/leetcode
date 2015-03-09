package leetcode;
//enumerate all cases.
public class ValidNumber {
    public boolean isNumber(String s) {
        //is_number=false;
        if(s==null){
            return false;
        }
        s=s.trim();
        if(s.equals("") || s.equals(".")){
            return false;
        }
        char current_char;
        int dot_counter=0;
        int e_counter=0;
        int number_counter=0;
        
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            s=s.substring(1,s.length());
        }
        
        
        for(int i=0;i<s.length();i++){
            current_char=s.charAt(i);
            if(current_char>='0' && current_char<='9'){
                number_counter++;
                continue;
            }else if(current_char=='.'){
                dot_counter++;
                if(dot_counter>=2 || (number_counter==0 && i<s.length()-1 && s.charAt(i+1)=='e') || e_counter>=1){
                    return false;
                }
            }else if(current_char=='e'){
                e_counter++;

                
                if(e_counter>=2 || i==0 || i==s.length()-1 || (i<s.length()-1 && s.charAt(i+1)=='.')){
                    return false;
                }
                if(i<s.length()-2 && (s.charAt(i+1)=='+' || s.charAt(i+1)=='-')){
                    i++;
                    continue;
                }
                
            }else{
                return false;
            }
        }
        
        if(number_counter>0){
            return true;
        }else{
            return false;
        }

    }
}
