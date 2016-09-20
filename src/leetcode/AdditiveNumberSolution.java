package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yufeijiang on 9/20/16.
 */
public class AdditiveNumberSolution {
    public boolean isAdditiveNumber(String num) {
        if(num==null || num.length()==0){
            return false;
        }
        for(int i=1; i<num.length();i++){
            for(int j=1;j<num.length()-i;j++){
                String firstNumberStr=num.substring(0,i);
                String secondNumberStr=num.substring(i,i+j);
                String thirdNumberStr=add(firstNumberStr,secondNumberStr);
                if((firstNumberStr.length()>1 && firstNumberStr.charAt(0)=='0') || (secondNumberStr.length()>1 && secondNumberStr.charAt(0)=='0') || (thirdNumberStr.length()>1 && thirdNumberStr.charAt(0)=='0')){
                    continue;
                }
                int firstLength=i;
                int secondLength=j;
                int totalLength=firstLength+secondLength;
                int thirdLength=thirdNumberStr.length();
                while(totalLength+thirdLength<=num.length()){
                    System.out.println(firstNumberStr);
                    System.out.println(secondNumberStr);
                    System.out.println(thirdNumberStr);
                    String expectedThirdNumberStr=num.substring(totalLength, totalLength+thirdLength);
                    System.out.println(expectedThirdNumberStr);
                    if(thirdNumberStr.equals(expectedThirdNumberStr)){
                        totalLength+=thirdLength;
                        firstNumberStr=secondNumberStr;
                        secondNumberStr=thirdNumberStr;
                        thirdNumberStr=add(firstNumberStr, secondNumberStr);
                        thirdLength=thirdNumberStr.length();
                    }else{
                        break;
                    }
                }
                if(totalLength==num.length()){
                    return true;
                }
            }
        }
        return false;
    }
    public String add(String s1,String s2){
        if(s1==null && s2==null){
            return null;
        }
        if(s1==null){
            return s2;
        }
        if(s2==null){
            return s1;
        }
        List<Character> list=new LinkedList();
        int length=Math.min(s1.length(), s2.length());
        int carryover=0;
        for(int i=1;i<=length;i++){
            char c1=s1.charAt(s1.length()-i);
            char c2=s2.charAt(s2.length()-i);
            if((c1-'0')+(c2-'0')+carryover<=9){
                char res=(char)(c1+c2+carryover-'0');
                list.add(res);
                carryover=0;
            }else{
                char res=(char)(c1+c2+carryover-10-'0');
                list.add(res);
                carryover=1;
            }
        }
        if(s1.length()==s2.length()){
            if(carryover==1){
                list.add('1');
            }
        }else{
            String longerStr;
            if(s1.length()==length){
                longerStr=s2;
            }else{
                longerStr=s1;
            }
            for(int i=length+1;i<=longerStr.length();i++){
                char c=longerStr.charAt(longerStr.length()-i);
                if((c+carryover-'0')<=9){
                    char res=(char)(c+carryover);
                    list.add(res);
                    carryover=0;
                }else{
                    char res=(char)(c+carryover-10);
                    list.add(res);
                    carryover=1;
                }
            }
            if(carryover==1){
                list.add('1');
            }
        }
        StringBuffer sb=new StringBuffer();
        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
