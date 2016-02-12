package leetcode;

/**
 * Created by yufeijiang on 2/11/16.
 */
public class PalindromeLinkedListSolution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        if(head.next==null){
            return true;
        }
        ListNode middle=findMiddle(head);
        ListNode middleHead=reverse(middle);

        ListNode node1=head;
        ListNode node2=middleHead;
        while(node1!=null && node2!=null){
            if(node1.val!=node2.val){
                return false;
            }
            node1=node1.next;
            node2=node2.next;
        }
        return true;

    }

    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode quick=head;
        while(quick!=null && quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        if(head.next==null){
            return head;
        }

        ListNode prev=null;
        ListNode next;
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
