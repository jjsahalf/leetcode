package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 9/6/16.
 */
public class UglyNumberIISolution {
    public int nthUglyNumber(int n) {
        List<Integer> list=new ArrayList();
        int p1=1;
        int p2=1;
        int p3=1;
        if(n==0){
            return -1;
        }
        list.add(-1);
        list.add(1);
        while(list.size()<=n+1){
            int multi2=list.get(p1)*2;
            int multi3=list.get(p2)*3;
            int multi5=list.get(p3)*5;
            int min=Math.min(multi2, multi3);
            min=Math.min(min,multi5);
            if(min==multi2){
                p1++;
            }
            if(min==multi3){
                p2++;
            }
            if(min==multi5){
                p3++;
            }
            list.add(min);
        }
        return list.get(n);
    }
}
