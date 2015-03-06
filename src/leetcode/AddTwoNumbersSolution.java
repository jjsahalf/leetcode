package leetcode;

public class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1==null || l2==null){
            System.out.println("invalid input");
            return null;
        }
        
        
        ListNode p1;
        ListNode p2;
        ListNode add_one;
        ListNode head_for_return;
        
        p1=l1;
        add_one=l1;
        p2=l2;
        
        int diff=align(p1, p2);
        
        int positive_diff=Math.abs(diff);
        
        
    
        
        
        if(diff>=0){
            head_for_return=l1;
            add_up(p1,p2);
            
        }else{
            head_for_return=l2;
            add_up(p2,p1);
        }
        return head_for_return;
        
    }
    
    
    public void add_up(ListNode p1, ListNode p2){
        ListNode in_p1=p1;
        ListNode in_p2=p2;
        
        int sum=0;
        
        while(in_p2!=null){
            sum=in_p1.val+in_p2.val;
            if(sum>=10){
                in_p1.val=sum-10;
                if(in_p1.next!=null){
                    ListNode next_sum=in_p1.next;
                    if(next_sum.val!=9){
                        next_sum.val++;
                    }else{
                        do{
                            next_sum.val=0;
                            if(next_sum.next!=null){
                                next_sum=next_sum.next;
                                next_sum.val++;
                            }else{
                                next_sum.next=new ListNode(1);
                                break;
                            }    
                            
                        }while(next_sum.val==10);
   
                    }
                }else{
                    in_p1.next=new ListNode(1);
                }
            }else{
                in_p1.val=in_p1.val+in_p2.val;
            }
            in_p1=in_p1.next;
            in_p2=in_p2.next;
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
