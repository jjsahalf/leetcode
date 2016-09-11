package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 9/11/16.
 */
public class FactorCombinationsSolution {
    public List<List<Integer>> getFactors(int n) {
        Set<List<Integer>> res=new HashSet();
        List<List<Integer>> resList=new ArrayList();
        if(n<=1){
            return resList;
        }
        double limit=Math.sqrt(n);
        List<Integer> curr=new ArrayList();
        for(int i=2;i<=limit;i++){
            if(n%i==0){
                if(n/i<i){
                    break;
                }else{
                    List<Integer> list=new ArrayList();
                    list.add(i);
                    list.add(n/i);
                    res.add(list);
                    List<List<Integer>> partRes=getFactors(n/i);
                    for(List l:partRes){
                        l.add(i);
                        Collections.sort(l);
                    }
                    res.addAll(partRes);
                }
            }
        }
        for(List l:res){
            resList.add(l);
        }
        return resList;
    }
}
