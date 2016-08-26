package leetcode;

/**
 * Created by yufeijiang on 8/26/16.
 */
public class PartitionListSolution {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode lastLess=dummy;
        ListNode lastGreat;
        while(lastLess.next!=null && lastLess.next.val<x){
            lastLess=lastLess.next;
        }
        if(lastLess.next==null){
            return head;
        }
        lastGreat=lastLess;
        while(lastGreat.next!=null && lastGreat.next.val>=x){
            lastGreat=lastGreat.next;
        }
        if(lastGreat.next==null){
            return head;
        }
        while(lastGreat.next!=null){
            if(lastGreat.next.val>=x){
                lastGreat=lastGreat.next;
            }else{
                ListNode temp1=lastLess.next;
                lastLess.next=lastGreat.next;
                lastGreat.next=lastGreat.next.next;
                lastLess=lastLess.next;
                lastLess.next=temp1;
            }
        }
        return dummy.next;
    }
}
