package leetcode;

/**
 * Created by yufeijiang on 6/29/16.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0){
            return null;
        }
        if(inorder.length==1){
            return new TreeNode(inorder[0]);
        }

        TreeNode root = new TreeNode(postorder[postorder.length-1]);

        int i=0;
        for(i=0; i<inorder.length;i++){
            if(root.val==inorder[i]){
                break;
            }
        }

        int[] leftInorder=new int[i];
        int[] leftPostorder=new int[i];
        for(int j=0;j<i;j++){
            leftInorder[j]=inorder[j];
            leftPostorder[j]=postorder[j];
        }

        int[] rightInorder=new int[inorder.length-1-i];
        int[] rightPostorder=new int[inorder.length-1-i];
        for(int j=0; j<rightInorder.length;j++){
            rightInorder[j]=inorder[i+1+j];
            rightPostorder[j]=postorder[i+j];
        }

        root.left=buildTree(leftInorder, leftPostorder);
        root.right=buildTree(rightInorder, rightPostorder);

        return root;



    }
}
