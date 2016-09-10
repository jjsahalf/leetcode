package leetcode;

import java.util.List;

/**
 * Created by yufeijiang on 9/10/16.
 */
public class Flatten2DVectorSolution {

    private List<List<Integer>> list;
    int smallMover;
    int bigMover;

    public Flatten2DVectorSolution(List<List<Integer>> vec2d) {
        this.list=vec2d;
        smallMover=0;
        bigMover=0;
    }


    public Integer next() {
        while(bigMover>=0 && bigMover<list.size() && smallMover==list.get(bigMover).size()){
            bigMover++;
            smallMover=0;
        }
        int res= list.get(bigMover).get(smallMover);
        smallMover++;
        return res;
    }


    public boolean hasNext() {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (bigMover >= list.size()) {
            return false;
        }
        if (bigMover >= 0 && bigMover < list.size() && smallMover >= 0 && smallMover < list.get(bigMover).size()) {
            return true;
        }
        if (smallMover == list.get(bigMover).size()) {
            while (bigMover >= 0 && bigMover < list.size() && smallMover == list.get(bigMover).size()) {
                bigMover++;
                smallMover = 0;
            }
            if (bigMover >= list.size()) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
