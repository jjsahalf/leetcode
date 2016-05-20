package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 5/20/16.
 */
public class CombinationSolution {

    /*
    应该牢记
    跟permutaiton比是没有了used数组,总是check比自己大的
    经典backtracking问题!
     */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList();

        if(n<=0){
            return list;
        }
        if(k>n){
            return list;
        }


        List<Integer> atom=new ArrayList();
        rec(1,n,k,list, atom);

        return list;


    }


    public void rec(int startNumber, int n, int k, List<List<Integer>> list, List<Integer> atom){
        if(atom.size()==k){
            List<Integer> fullList=new ArrayList(atom);
            list.add(fullList);
            return;
        }else{
            for(int i=startNumber; i<=n; i++){
                atom.add(i);
                rec(i+1, n, k, list, atom);
                atom.remove(atom.size()-1);
            }
        }
    }
}
