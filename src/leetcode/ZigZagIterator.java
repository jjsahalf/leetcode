package leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yufeijiang on 9/13/16.
 */
public class ZigZagIterator {
    private List<Integer> list1;
    private List<Integer> list2;
    int counter;
    private Iterator<Integer> it1;
    private Iterator<Integer> it2;

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        this.list1=v1;
        this.list2=v2;
        counter=0;
        it1=list1.iterator();
        it2=list2.iterator();
    }

    public int next() {
        if(it1.hasNext() && (!it2.hasNext())){
            counter++;
            return it1.next();
        }
        if((!it1.hasNext()) && it2.hasNext()){
            counter++;
            return it2.next();
        }
        if(counter%2==0){
            counter++;
            return it1.next();
        }else{
            counter++;
            return it2.next();
        }
    }

    public boolean hasNext() {
        if( (!it1.hasNext()) && (!it2.hasNext()) ){
            return false;
        }else{
            return true;
        }
    }
}
