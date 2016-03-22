package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 3/22/16.
 */
public class MultiplyStringsSolution {


    public String multiply(String num1, String num2) {
        if(num1==null || num2==null){
            return null;
        }
        if(num1.equals("")||num2.equals("")){
            return "";
        }

        if(num1.equals("0")|| num2.equals("0")){
            return "0";
        }

        Map<Integer, Integer> map=new HashMap();
        int length1=num1.length();
        int length2=num2.length();
        for(int i=length2-1;i>=0;i--){
            Character currentNum2Char=num2.charAt(i);
            Integer currentNum2Number=currentNum2Char-'0';
            for(int j=length1-1;j>=0;j--){
                Character currentNum1Char=num1.charAt(j);
                Integer currentNum1Number=currentNum1Char-'0';
                Integer local=currentNum1Number*currentNum2Number;
                Integer position=(length1-j-1)+(length2-i-1);
                Integer remainder=local%10;
                Integer upgrade=0;
                if(local>=10){
                    upgrade=local/10;
                }
                if(map.containsKey(position)){
                    Integer localSum=map.get(position)+remainder;
                    remainder=localSum%10;
                    Integer newUpgrade=0;
                    if(localSum>=10){
                        newUpgrade=localSum/10;
                    }
                    upgrade+=newUpgrade;
                    map.put(position, remainder);
                }else{
                    map.put(position,remainder);
                }
                Integer movingPosition=position+1;
                while(upgrade>0){
                    if(map.containsKey(movingPosition)){
                        Integer localSum=map.get(movingPosition)+upgrade;
                        remainder=localSum%10;
                        if(localSum>=10){
                            upgrade=localSum/10;
                        }else{
                            upgrade=0;
                        }
                        map.put(movingPosition,remainder);
                    }else{
                        map.put(movingPosition,upgrade);
                        upgrade=0;
                    }
                    movingPosition++;
                }
            }
        }

        Integer size=map.size();
        Integer key=size-1;
        StringBuffer sb=new StringBuffer();
        while(key>=0){
            Integer value=map.get(key);
            sb.append(value.toString());
            key--;
        }

        return sb.toString();

    }
}
