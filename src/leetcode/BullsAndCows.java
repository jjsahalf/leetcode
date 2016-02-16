package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 2/16/16.
 */
public class BullsAndCows {
    /*


   THIS ONE IS BETTER, ONE ARRAY, ONE ROUND OF TRAVERSE
   
        public String getHint(String secret, String guess) {

        if (secret == null || guess == null || secret.length() != guess.length()) {
            return "";
        }

        int countA = 0;
        int countB = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                count[secret.charAt(i) - '0']++;
                if (count[secret.charAt(i) - '0'] <= 0) {
                    countB++;
                }
                count[guess.charAt(i)- '0']--;
                if (count[guess.charAt(i)- '0'] >= 0) {
                    countB++;
                }
            }
        }

        return String.valueOf(countA) + "A" + String.valueOf(countB) + "B";
    }


     */









    public String getHint(String secret, String guess) {
        Integer bulls=0;
        Integer cows=0;
        HashMap<Character, Integer> secretMap=new HashMap();
        HashMap<Character, Integer> guessMap=new HashMap();
        for(int i=0;i<secret.length();i++){
            Character secretChar=secret.charAt(i);
            Character guessChar=guess.charAt(i);
            if(secretChar.equals(guessChar)){
                bulls++;
            }else{
                if(secretMap.containsKey(secretChar)){
                    secretMap.put(secretChar,secretMap.get(secretChar)+1);
                }else{
                    secretMap.put(secretChar,1);
                }

                if(guessMap.containsKey(guessChar)){
                    guessMap.put(guessChar, guessMap.get(guessChar)+1);
                }else{
                    guessMap.put(guessChar,1);
                }
            }
        }


        for(Map.Entry<Character, Integer> entry: guessMap.entrySet()){
            Character entryChar=entry.getKey();
            Integer entryValue=entry.getValue();
            if(secretMap.containsKey(entryChar)){
                if(entryValue>secretMap.get(entryChar)){
                    cows+=secretMap.get(entryChar);
                }else{
                    cows+=entryValue;
                }
            }
        }

        String str=bulls.toString()+"A"+cows.toString()+"B";
        return str;

    }

}
