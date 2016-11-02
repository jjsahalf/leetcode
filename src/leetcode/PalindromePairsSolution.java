package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yufeijiang on 11/2/16.
 */
public class PalindromePairsSolution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList();
        if(words==null || words.length==0){
            return res;
        }
        Map<String, Integer> map=new HashMap();
        for(int i=0; i<words.length;i++){
            map.put(words[i],i);
        }
        for(int i=0;i<words.length;i++){
            if(words[i].equals("")){
                continue;
            }
            for(int j=1;j<=words[i].length();j++){
                String curr=words[i];
                String str1=curr.substring(0,j);
                String str2=curr.substring(j);
                if(isPalindrome(str1)){
                    if(j!=words[i].length()){
                        if(map.containsKey(new StringBuffer(str2).reverse().toString()) && map.get(new StringBuffer(str2).reverse().toString())!=i ){
                            List<Integer> list=new ArrayList();
                            list.add(map.get(new StringBuffer(str2).reverse().toString()));
                            list.add(i);
                            res.add(list);
                        }
                    }else{
                        if(map.containsKey("")){
                            List<Integer> list=new ArrayList();
                            list.add(i);
                            list.add(map.get(""));
                            res.add(list);
                            list=new ArrayList();
                            list.add(map.get(""));
                            list.add(i);
                            res.add(list);
                        }
                    }
                }
                if(isPalindrome(str2)){
                    if(map.containsKey(new StringBuffer(str1).reverse().toString()) && map.get(new StringBuffer(str1).reverse().toString())!=i ){
                        List<Integer> list=new ArrayList();
                        list.add(i);
                        list.add(map.get(new StringBuffer(str1).reverse().toString()));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String str){
        if(str==null || str.length()==0){
            return true;
        }
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
