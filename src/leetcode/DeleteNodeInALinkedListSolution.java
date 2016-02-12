package leetcode;

/**
 * Created by yufeijiang on 2/12/16.
 */
public class DeleteNodeInALinkedListSolution {
    /*
    what I wrote is wrong.
    I should directly discard next node and fetch its value.
    Like this:
        public void deleteNode(ListNode node) {
        //input check
        if(node==null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }


     */




    public void deleteNode(ListNode node) {
        if(node==null){
            return;
        }
        ListNode prev=null;
        while(node.next!=null){
            node.val=node.next.val;
            prev=node;
            node=node.next;
        }

        prev.next=null;

    }
}
