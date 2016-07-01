package leetcode;

/**
 * Created by yufeijiang on 6/29/16.
 */

//better than the solution I searched online.
public class ConvertSortedListoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {

        return treeBuilder(head,null);

    }


    public TreeNode treeBuilder(ListNode start, ListNode end){
        if(start==end){
            return null;
        }
        if(start.next==end){
            return new TreeNode(start.val);
        }

        ListNode middle=start;
        ListNode tail=start;
        while(tail!=end && tail.next!=end){
            tail=tail.next.next;
            middle=middle.next;
        }


        TreeNode root=new TreeNode(middle.val);
        root.left=treeBuilder(start, middle);
        root.right=treeBuilder(middle.next, end);


        return root;


    }
}
