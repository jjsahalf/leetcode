/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedListISolution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode secondNode=head.next;
        head.next=null;
        ListNode newHead=reverseList(secondNode);
        secondNode.next=head;
        return newHead;
    }
}