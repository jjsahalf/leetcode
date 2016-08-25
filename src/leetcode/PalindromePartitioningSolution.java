package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 8/25/16.
 */
public class PalindromePartitioningSolution {
    public List<List<String>> partition(String s) {
        List<List<String>> allList=new ArrayList();
        if(s==null || s.length()==0){
            return allList;
        }
        helper(s, 0, new ArrayList(), allList);
        return allList;
    }

    public void helper(String s, int start, List<String> list, List<List<String>> allList){
        if(start>=s.length()){
            allList.add(new ArrayList(list));
        }
        for(int i=start+1; i<=s.length(); i++){
            String current=s.substring(start, i);
            if(isPalindrome(current)){
                list.add(current);
                helper(s, i, list, allList);
                if(!list.isEmpty()){
                    list.remove(list.size()-1);
                }
            }
        }
    }
    public boolean isPalindrome(String s){
        int i=0;
        int lastIndex=s.length()-1;
        while(i<=lastIndex-i){
            if(s.charAt(i)!=s.charAt(lastIndex-i)){
                return false;
            }
            i++;
        }
        return true;
    }
}
