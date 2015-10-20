package leetcode;

/**
 * Created by yufeijiang on 10/20/15.
 */
public class RemoveDuplicatesFromSortedListSolution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode cursor=head;
        while(cursor.next!=null){
            if(cursor.next.val==cursor.val){
                cursor.next=cursor.next.next;
            }else{
                cursor=cursor.next;
            }
        }

        return head;


    }
}
