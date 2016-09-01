package leetcode;

/**
 * Created by yufeijiang on 9/1/16.
 */
public class PlusOneLinkedListSolution {
    public ListNode plusOne(ListNode head) {
        if(head==null){
            return null;
        }
        head=reverseList(head);
        ListNode mover=head;
        boolean carryover=true;
        while(carryover){
            if(mover.val!=9){
                mover.val++;
                carryover=false;
            }else{
                mover.val=0;
                if(mover.next==null){
                    mover.next=new ListNode(0);
                }
                mover=mover.next;
            }
        }
        head=reverseList(head);
        return head;
    }
    public ListNode reverseList(ListNode head){
        ListNode mover=head;
        ListNode prev=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}
