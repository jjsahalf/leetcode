package leetcode;

public class AddTwoNumbersSolution2 {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1==null || l2==null){
            System.out.println("invalid input");
            return null;
        }
        
        int longer_index=0;
        
        ListNode p1;
        ListNode p2;
        ListNode add_one;
        ListNode head_for_return;
        
        p1=l1;
        add_one=l1;
        p2=l2;
        
        int diff=align(p1, p2);
        
        int positive_diff=Math.abs(diff);
        
        if(diff==0){
            if(p1.val+p2.val>=10){
                head_for_return=new ListNode(1);
                head_for_return.next=p1;
                p1.val=p1.val+p2.val-10;
                add_one=head_for_return;
                if(p1.next!=null){
                    p1=p1.next;
                    p2=p2.next;
                    add_one=add_one.next;
                    add_up(add_one,p1,p2);
                }
                
                return head_for_return;
            }else{
            	head_for_return=p1;
            	p1.val=p1.val+p2.val;
            	if(p1.next!=null){
            		p1=p1.next;
            		p2=p2.next;
            		add_one=head_for_return;
            		add_up(add_one,p1,p2);
            		
            	}
            	return head_for_return;
            }
        }
        
        
        if(diff>0){
            head_for_return=l1;
            while(positive_diff>1){
                p1=p1.next;
                positive_diff--;
            }
            add_one=p1;
            p1=p1.next;
            
            add_up(add_one,p1,p2);
            
            return head_for_return;
        }else{
            head_for_return=l2;
            while(positive_diff>1){
                p2=p2.next;
                positive_diff--;
            }
            add_one=p2;
            p2=p2.next;
            
            add_up(add_one,p2,p1);
            
            return head_for_return;
        }
        
    }
    
    
    public void add_up(ListNode add_one, ListNode p1, ListNode p2){
        ListNode in_add_one=add_one;
        ListNode in_p1=p1;
        ListNode in_p2=p2;
        
        int sum=0;
        
        while(in_p1!=null){
            sum=p1.val+p2.val;
            if(sum>=10){
                in_add_one.val++;
                p1.val=sum-10;
            }else{
                p1.val=p1.val+p2.val;
            }
            in_p1=in_p1.next;
            in_p2=in_p2.next;
            in_add_one=in_add_one.next;
        }
    }
    
    public int align(ListNode p1, ListNode p2){
        int length1=1;
        int length2=1;
        
        ListNode temp1=p1;
        ListNode temp2=p2;
        
        while(temp1.next!=null){
            temp1=temp1.next;
            length1++;
        }
        
        while(temp2.next!=null){
            temp2=temp2.next;
            length2++;
        } 
        
        return length1-length2;
        
        
    }
    

}
