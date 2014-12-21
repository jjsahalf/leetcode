package leetcode;

import java.util.HashSet;
import java.util.Set;
//O(n) time but O(1) space
//we might need to scan it two rounds.
//this problem description is not very clear
//actually it means two linked list must end with the same ending or 
// do not intersect at all
public class LinkedListIntersectionSolution {
	
	private Set<ListNode> nodes_set=new HashSet<ListNode>();
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA==null || headB==null){
    		return null;
    	}
    	
    	if(headA==headB){
    		return headA;
    	}
    	
    	int a_length=1;
    	ListNode itA=headA;
    	while(itA.next!=null){
    		itA=itA.next;
    		a_length++;
    	}
    	
    	int b_length=1;
    	ListNode itB=headB;
    	while(itB.next!=null){
    		itB=itB.next;
    		b_length++;
    	}
    	
    	itA=headA;
    	itB=headB;

		
		int shift=Math.max(a_length, b_length)-Math.min(a_length, b_length);
		ListNode move_node=null;
		if(a_length>b_length){
			move_node=headA;
		}else{
			move_node=headB;
		}
		for(int i=0;i<shift;i++){
			move_node=move_node.next;
		}
		if(a_length>b_length){
			itA=move_node;
			itB=headB;
		}else{
			itA=headA;
			itB=move_node;
		}
		
		do {
			if (itA == itB) {
				return itA;
			}
			itA=itA.next;
			itB=itB.next;
		} while (itA != null);
		return null;
    }

}
