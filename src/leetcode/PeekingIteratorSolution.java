package leetcode;

import java.util.Iterator;

/**
 * Created by yufeijiang on 9/13/16.
 */
public class PeekingIteratorSolution implements Iterator<Integer> {
    private Iterator<Integer> it;
    private int peekNumber;
    private boolean hasNext;

    public PeekingIteratorSolution(Iterator<Integer> iterator) {
        it=iterator;
        if(it.hasNext()){
            peekNumber=it.next();
            hasNext=true;
        }else{
            hasNext=false;
        }

        // initialize any member here.

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return this.peekNumber;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res=this.peekNumber;
        if(it.hasNext()){
            this.peekNumber=it.next();
            hasNext=true;
        }else{
            hasNext=false;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }
}
