package leetcode;

/**
 * Created by yufeijiang on 2/18/16.
 */
public class OddEvenLinkedListSolution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode oddHead=head;
        ListNode oddIt=oddHead;
        ListNode evenHead=head.next;
        ListNode evenIt=evenHead;
        while(oddIt.next!=null && oddIt.next.next!=null){
            oddIt.next=oddIt.next.next;
            oddIt=oddIt.next;
            if(evenIt.next.next!=null){
                evenIt.next=evenIt.next.next;
                evenIt=evenIt.next;
            }else{
                evenIt.next=null;
                break;
            }
        }
        oddIt.next=evenHead;
        return oddHead;
    }
}
