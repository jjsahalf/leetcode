package leetcode;

/**
 * Created by yufeijiang on 6/29/16.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }

        int middle=nums.length/2;
        TreeNode root=new TreeNode(nums[middle]);

        int[] leftNums=new int[middle];
        for(int i=0; i<middle;i++){
            leftNums[i]=nums[i];
        }


        int[] rightNums=new int[nums.length-middle-1];
        for(int i=0; i<rightNums.length;i++){
            rightNums[i]=nums[middle+1+i];
        }

        root.left=sortedArrayToBST(leftNums);
        root.right=sortedArrayToBST(rightNums);

        return root;

    }
}
