package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 6/21/16.
 */
public class GrayCodeSolution {
    public List<Integer> grayCode(int n) {
        List<Integer> list;
        if(n==0){
            list = new ArrayList();
            list.add(0);
            return list;
        }
        list=grayCode(n-1);
        int currentSize=list.size();
        int currentAddNumber=1<<(n-1);
        for(int i=currentSize-1;i>=0;i--){
            int element=list.get(i);
            list.add(currentAddNumber+element);
        }

        return list;
    }
}
