package leetcode;

/**
 * Created by yufeijiang on 8/27/15.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//the interesting part is about how to handle the case that n==length
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode itNode=head;
        int length=1;
        while(itNode.next!=null){
            length++;
            itNode=itNode.next;
        }
        if(length==n){
            return head.next;
        }else{
            int removedIndex=length-n;
            ListNode dummyHead=new ListNode(-1);
            dummyHead.next=head;
            ListNode preItNode=dummyHead;
            itNode=head;
            for(int i=0;i<removedIndex;i++){
                preItNode=preItNode.next;
                itNode=itNode.next;
            }
            preItNode.next=itNode.next;
            return head;
        }
    }
}
