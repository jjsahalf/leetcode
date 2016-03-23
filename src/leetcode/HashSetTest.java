package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yufeijiang on 3/22/16.
 */
public class HashSetTest {

    public static void main(String[] args){
        Set<List<Integer>> set= new HashSet();
        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(2);
        set.add(list);
        List<Integer> list2=new ArrayList();
        list2.add(1);
        list2.add(2);
        set.add(list2);
        System.out.println(set.size());
    }
}
