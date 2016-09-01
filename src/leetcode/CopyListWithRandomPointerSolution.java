package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 9/1/16.
 */
public class CopyListWithRandomPointerSolution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        Map<RandomListNode, RandomListNode> map=new HashMap();
        RandomListNode mover=head;
        while(mover!=null){
            RandomListNode copy=new RandomListNode(mover.label);
            map.put(mover, copy);
            mover=mover.next;
        }
        mover=head;
        while(mover!=null){
            map.get(mover).next=map.get(mover.next);
            map.get(mover).random=map.get(mover.random);
            mover=mover.next;
        }
        return map.get(head);
    }
}
