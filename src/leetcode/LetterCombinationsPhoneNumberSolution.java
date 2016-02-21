package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yufeijiang on 2/20/16.
 */
public class LetterCombinationsPhoneNumberSolution {
/*
大多数人用的深度优先,似乎更好.
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();

        if (digits == null || digits.equals("")) {
            return result;
        }

        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        StringBuilder sb = new StringBuilder();
        helper(map, digits, sb, result);

        return result;
    }

    private void helper(Map<Character, char[]> map, String digits,
        StringBuilder sb, ArrayList<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(map, digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
 */

    private Map<Character, String> map;

    public LetterCombinationsPhoneNumberSolution(){
        map=new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        map.put('0'," ");

    }



    public List<String> letterCombinations(String digits) {
        if(digits==null){
            return null;
        }
        List<String> list=new ArrayList();
        if(digits.equals("")){
            return list;
        }


        bfs(list,digits);

        return list;


    }

    protected List<String> bfs(List<String> list, String digits){
        if(digits==null){
            return list;
        }
        if(digits.equals("")){
            return list;
        }
        Character current=digits.charAt(0);
        String mapStr=map.get(current);

        int size=list.size();

        if(list.size()==0){
            for(int j=0;j<mapStr.length();j++){
                Character currentChar=mapStr.charAt(j);
                String updateString=currentChar.toString();
                list.add(updateString);
            }
        }else{
            for(int i=0; i<size;i++){
                String origin=list.get(i);
                for(int j=0;j<mapStr.length();j++){
                    Character currentChar=mapStr.charAt(j);
                    String updateString=origin+currentChar.toString();
                    list.add(updateString);
                }
            }
            for(int i=0;i<size;i++){
                list.remove(0);
            }
        }

        return bfs(list, digits.substring(1,digits.length()));

    }
}
