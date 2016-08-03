package leetcode;

/**
 * Created by yufeijiang on 8/2/16.
 */
public class ReorderList {
    public void reorderListSolution(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return;
        }

        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode secondHalfHead=slow.next;
        slow.next=null;

        ListNode tail=null;
        while(secondHalfHead.next!=null){
            ListNode next=secondHalfHead.next;
            secondHalfHead.next=tail;
            tail=secondHalfHead;
            secondHalfHead=next;
        }
        secondHalfHead.next=tail;

        ListNode firstHalf=head;

        ListNode secondHalf=secondHalfHead;

        while(firstHalf!=null && secondHalf!=null){
            ListNode firstTemp=firstHalf.next;
            firstHalf.next=secondHalf;
            ListNode secondTemp=secondHalf.next;
            secondHalf.next=firstTemp;
            firstHalf=firstTemp;
            secondHalf=secondTemp;
        }
        return;

    }
}
