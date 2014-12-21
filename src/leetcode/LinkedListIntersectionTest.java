package leetcode;

public class LinkedListIntersectionTest {

	public static void main(String[] args) {
		LinkedListIntersectionSolution instance=new LinkedListIntersectionSolution();
		ListNode headA=new ListNode(3);
		ListNode headB=new ListNode(2);
		headB.next=new ListNode(3);
		ListNode res=instance.getIntersectionNode(headA, headB);
		if(res==null){
			System.out.println("something");
		}

	}

}
