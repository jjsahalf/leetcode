package leetcode;

public class SortListSolution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode slow=dummyHead;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=slow.next;
        ListNode firstHalf=head;
        slow.next=null;
        ListNode newFirstHalf=sortList(firstHalf);
        ListNode newSecondHalf=sortList(secondHalf);
        return merge(newFirstHalf,newSecondHalf);
    }
    
    
    public ListNode merge(ListNode firstHalf, ListNode secondHalf){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=firstHalf;
        ListNode firstHalfCursor=firstHalf;
        ListNode secondHalfCursor=secondHalf;
        ListNode previous=dummyHead;
        while(firstHalfCursor!=null && secondHalfCursor!=null){
            if(firstHalfCursor.val>secondHalfCursor.val){
                previous.next=secondHalfCursor;
                ListNode nextNode=secondHalfCursor.next;
                secondHalfCursor.next=firstHalfCursor;
                secondHalfCursor=nextNode;
                previous=previous.next;
               
                
            }else{
                firstHalfCursor=firstHalfCursor.next;
                previous=previous.next;
            }
        }
        
        if(firstHalfCursor==null){
            previous.next=secondHalfCursor;
        }
        
        if(secondHalfCursor==null){
            previous.next=firstHalfCursor;
        }
        
        return dummyHead.next;
        
    }
    
    
}