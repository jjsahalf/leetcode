package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 10/6/16.
 */
public class IntegerToEnglishWordsSolution {
    private Map<Integer, String> map;

    public String numberToWords(int num) {
        map=new HashMap();
        fillMap();
        StringBuffer sb=new StringBuffer();
        if(num==0){
            return "Zero";
        }
        if(num>=1000000000){
            int digit=num/1000000000;
            sb.append(helper(digit)+" Billion ");
            num=num%1000000000;
        }
        if(num>=1000000){
            int digit=num/1000000;
            sb.append(helper(digit)+" Million ");
            num=num%1000000;
        }
        if(num>=1000){
            int digit=num/1000;
            sb.append(helper(digit)+" Thousand ");
            num=num%1000;
        }
        if(num>0){
            int digit=num;
            sb.append(helper(digit));
        }
        String str = sb.toString();
        if(str.charAt(str.length()-1)==' '){
            str=str.substring(0,str.length()-1);
        }
        return str;
    }
    public String helper(int num){
        int origNumber=num;
        StringBuffer sb=new StringBuffer();
        if(num>=100){
            int digit=num/100;
            sb.append(map.get(digit)+" Hundred");
        }
        num=num%100;
        if(num>0){
            if(origNumber>100){
                sb.append(" ");
            }
            if(num<20){
                sb.append(map.get(num));
            }
            if(num>=20){
                int tenDigits=num/10*10;
                sb.append(map.get(tenDigits));
                num=num%10;
                if(num!=0){
                    sb.append(" "+map.get(num));
                }
            }
        }
        return sb.toString();
    }
    private void fillMap(){
        map.put(0,"Zero");
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
        map.put(11,"Eleven");
        map.put(12,"Twelve");
        map.put(13,"Thirteen");
        map.put(14,"Fourteen");
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(20,"Twenty");
        map.put(30,"Thirty");
        map.put(40,"Forty");
        map.put(50,"Fifty");
        map.put(60,"Sixty");
        map.put(70,"Seventy");
        map.put(80,"Eighty");
        map.put(90,"Ninety");
    }
}
