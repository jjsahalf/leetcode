package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//1,2,3,4
//1,4,3,2
public class ReverseLinkedListSolution {
	
	//private ListNode temp_node;
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head==null){
    		return null;
    	}
    	
    	if(head==null || head.next==null || m==n){
    		return head;
    	}
    	

    	//we use five pointers here.
    	ListNode temp_node=null;
    	ListNode first_node=head.next;
    	ListNode the_node_before_first=head;
    	ListNode it_node=head.next;
    	ListNode temp2=null;
    	if(m==1){
    		//add a dummy node is the key to solve this problem
    		//start from 1 or not are two problems, we need to
    		//unify them as one
    		//here we just add dummy node in the case that m=1
    		//in some solutions, we can always add a dummy node.
        	ListNode fake_head=new ListNode(0);
        	fake_head.next=head;
    		head=fake_head;
        	first_node=head.next;
        	the_node_before_first=head;
        	it_node=first_node.next;
    	}else {
			for (int i = 0; i < m - 2; i++) {
				the_node_before_first = the_node_before_first.next;
				first_node=first_node.next;
			}
			it_node=first_node.next;
		}

		temp_node=null;

		
		for(int counter=0;counter<n-m;counter++){
			temp_node=it_node.next;
			temp2=the_node_before_first.next;
			the_node_before_first.next=it_node;
			it_node.next=temp2;
			first_node.next=temp_node;
			//first_node=it_node;
			it_node=temp_node;
		}
    	
    	if(m==1){
    		return head.next;
    	}
        return head;
    }
}
