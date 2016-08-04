package leetcode;

/**
 * Created by yufeijiang on 8/3/16.
 */
public class InsertionSortListSolution {
    //Insertion sort does not necessarily compare from big end
    //Can be compared from the small end.

    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode orderTail=head;
        ListNode noOrderFirst=orderTail.next;

        while(noOrderFirst!=null){
            if(orderTail.val<=noOrderFirst.val){
                orderTail=orderTail.next;
                noOrderFirst=noOrderFirst.next;
            }else{
                ListNode toInsertNode=noOrderFirst;
                noOrderFirst=noOrderFirst.next;
                orderTail.next=noOrderFirst;
                ListNode pre=dummyHead;
                while(toInsertNode.val>pre.next.val){
                    pre=pre.next;
                }
                ListNode next=pre.next;
                pre.next=toInsertNode;
                toInsertNode.next=next;
            }
        }
        return dummyHead.next;
    }
}
