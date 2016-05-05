package leetcode;

/**
 * Created by yufeijiang on 5/5/16.
 */
public class RotateListSolution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==0){
            return head;
        }

        int length=1;
        ListNode mover=head;
        while(mover.next!=null){
            mover=mover.next;
            length++;
        }



        int step=length-k%length-1;
        if(step==-1){
            return head;
        }else{
            mover.next=head;
            mover=head;
            for(int i=0;i<step;i++){
                mover=mover.next;
            }
            head=mover.next;
            mover.next=null;
            return head;
        }

    }
}
