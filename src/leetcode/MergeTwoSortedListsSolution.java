package leetcode;

public class MergeTwoSortedListsSolution {
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode it_1=l1;
    	ListNode it_2=l2;
    	
    	ListNode head;
    	//make the dummy one 
    	//and return dummy.next;
    	ListNode it_3=new ListNode(1);
    	
    	if(l1==null && l2==null){
    		return null;
    	}
    	
    	
    	head=it_3;
    	
    	while(it_1!=null || it_2!=null){
    		if(it_1==null){
    			it_3.next=it_2;
    			break;
    		}
    		if(it_2==null){
    			it_3.next=it_1;
    			break;
    		}
    		if(it_1.val<=it_2.val){
    			it_3.next=it_1;
    			it_3=it_3.next;
    			it_1=it_1.next;
    		}else{
    			it_3.next=it_2;
    			it_3=it_3.next;
    			it_2=it_2.next;
    		}
    	}
    	
    	return head.next;
    }


}
