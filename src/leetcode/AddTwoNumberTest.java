package leetcode;

public class AddTwoNumberTest {

	public static void main(String[] args) {
		ListNode l1=new ListNode(9);
		l1.next=new ListNode(8);
		ListNode l2=new ListNode(1);
		//l2.next=new ListNode(9);
		AddTwoNumbersSolution instance=new AddTwoNumbersSolution();
		ListNode res=instance.addTwoNumbers(l1, l2);
		System.out.println(res);
		
	}

}
