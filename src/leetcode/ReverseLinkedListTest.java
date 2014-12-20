package leetcode;

public class ReverseLinkedListTest {

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		//head.next=new ListNode(5);
		ListNode it_node=head;
		for(int i=2;i<=2;i++){
			
			it_node.next=new ListNode(i);
			it_node=it_node.next;
		}
		
		ReverseLinkedListSolution instance =new ReverseLinkedListSolution();
		ListNode h=instance.reverseBetween(head, 1, 2);
		do{
			System.out.println(h.val);
			h=h.next;
		}while(h.next!=null);

	}

}
