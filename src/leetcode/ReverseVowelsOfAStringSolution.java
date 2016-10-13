package leetcode;

/**
 * Created by yufeijiang on 10/12/16.
 */
public class ReverseVowelsOfAStringSolution {
    public String reverseVowels(String s) {
        if(s==null || s.equals("")){
            return s;
        }
        char[] charArray=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        String vowels="AEIOUaeiou";
        while(i<j){
            while(i<s.length() && vowels.indexOf(s.charAt(i))==-1  )  {
                i++;
            }
            if(i==s.length()){
                return s;
            }
            while(j>=0 && vowels.indexOf(s.charAt(j))==-1 ){
                j--;
            }
            if(i<j){
                char temp=charArray[i];
                charArray[i]=charArray[j];
                charArray[j]=temp;
                i++;
                j--;
            }else{
                break;
            }
        }
        return new String(charArray);
    }
}
