package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 9/14/16.
 */
public class GeneralizedAbbreviationSolution {
    public List<String> generateAbbreviations(String word) {
        List<String> list=new ArrayList();
        int[] visited=new int[word.length()];
        Character[] chars=new Character[word.length()];
        for(Character c:chars){
            c=null;
        }
        if(word==null || word.length()==0){
            list.add("");
            return list;
        }
        helper(list,chars,0,word);
        return list;
    }
    public void helper(List<String> list, Character[] chars, int start, String word){
        //handle
        Integer counter=0;
        StringBuffer res=new StringBuffer();
        for(int i=0;i<chars.length;i++){
            if(chars[i]==null){
                counter++;
            }else{
                if(counter!=0){
                    res.append(counter.toString());
                    counter=0;
                }
                res.append(chars[i]);
            }
        }
        if(counter!=0){
            res.append(counter.toString());
            counter=0;
        }
        list.add(res.toString());
        for(int i=start;i<word.length();i++){
            chars[i]=word.charAt(i);
            helper(list, chars,i+1,word);
            chars[i]=null;
        }
    }
    
}
