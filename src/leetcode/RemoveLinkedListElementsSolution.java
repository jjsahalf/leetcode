package leetcode;

/**
 * Created by yufeijiang on 2/8/16.
 */
public class RemoveLinkedListElementsSolution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode previous=dummyHead;
        ListNode current=head;

        while(current!=null){
            if(current.val==val){
                previous.next=current.next;
                current=current.next;
            }else{
                previous=current;
                current=current.next;
            }
        }

        return dummyHead.next;


    }
}
