/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; }

 * }

 */

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null){

            return null;

        }

        

        if(head.next==null){

            return head;

        }

        

        ListNode dummyHead=new ListNode(-1);

        ListNode itNode=head.next;

        ListNode previousItNode=head;

        ListNode singleNumberTailNode=dummyHead;

        dummyHead.next=head;

        

        int currentCounter=1;

        int currentValue=head.val;

        int value;

        while(itNode!=null){

            value=itNode.val;

            if(value!=currentValue){

                currentValue=value;

                if(currentCounter==1){

                    singleNumberTailNode=previousItNode;

                }else{

                    singleNumberTailNode.next=itNode;

                }

                currentCounter=1;

            }else{

                currentCounter++;

            }

            itNode=itNode.next;

            previousItNode=previousItNode.next;

        }

        

        if(currentCounter>1){

            singleNumberTailNode.next=null;

        }

        

        return dummyHead.next;

        

    }

}
