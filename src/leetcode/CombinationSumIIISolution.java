package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 10/31/16.
 */
public class CombinationSumIIISolution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList();
        if(k<0 || n<=0){
            return list;
        }
        helper(k,n,1,list,new ArrayList());
        return list;
    }
    public void helper(int k, int n, int start, List<List<Integer>> res, List<Integer> list){
        if(k==0){
            if(n==0){
                res.add(new ArrayList(list));
                return;
            }else{
                return;
            }
        }
        for(int i=start;i<=9;i++){
            if(n-i>=0){
                list.add(i);
                helper(k-1,n-i,i+1,res,list);
                list.remove(list.size()-1);
            }else{
                return;
            }
        }
    }
}
