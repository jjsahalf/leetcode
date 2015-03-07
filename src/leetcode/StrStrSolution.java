package leetcode;

public class StrStrSolution {
    //a special case:
    //aab and aaab
    //best algorithm:KMP
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null ){
            return -1;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        
        if(haystack.equals(needle)){
            return 0;
        }
        
        int hay_slow=0;
        int hay_fast=0;
        
        for(hay_slow=0;hay_slow<haystack.length()-needle.length()+1;hay_slow++){
            hay_fast=hay_slow;
            boolean is_match=true;
            while((hay_fast-hay_slow)<needle.length()){
                if(haystack.charAt(hay_fast)==needle.charAt(hay_fast-hay_slow)){
                    hay_fast++;
                }else{
                    is_match=false;
                    break;
                }
            }
            if(is_match==true){
                return hay_slow;
            }   
        }
        return -1;        
    }
}
