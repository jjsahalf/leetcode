package leetcode;

/**
 * Created by yufeijiang on 7/29/16.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;    //meet null, no loop there
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;    //meet at Z point
            }
        }

        slow = head;    //slow runs from the head.
        while (slow != fast) {    //quit when they meet at Y
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
