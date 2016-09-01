package leetcode;

/**
 * Created by yufeijiang on 9/1/16.
 */
public class ReverseNodesInkGroupDolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1){
            return head;
        }
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        boolean hasMore=true;
        ListNode prev=dummyNode;
        ListNode mover=head;
        while(true){
            hasMore=reverse(prev, mover, k);
            if(hasMore){
                prev=mover;
                mover=mover.next;
            }else{
                break;
            }
        }
        return dummyNode.next;
    }
    public boolean reverse(ListNode prev, ListNode head, int k){
        ListNode mover=head;
        for(int i=0; i<k;i++){
            if(mover==null){
                return false;
            }
            mover=mover.next;
        }
        mover=head;
        ListNode pre=null;
        for(int i=0;i<k;i++){
            ListNode temp=mover.next;
            mover.next=pre;
            pre=mover;
            mover=temp;
        }
        ListNode last=head;
        ListNode first=pre;
        last.next=mover;
        prev.next=first;
        return true;
    }
}
