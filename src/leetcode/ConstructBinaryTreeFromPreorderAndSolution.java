package leetcode;

/**
 * Created by yufeijiang on 6/29/16.
 */
public class ConstructBinaryTreeFromPreorderAndSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null){
            return null;
        }
        if(preorder.length==0){
            return null;
        }

        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }

        TreeNode root=new TreeNode(preorder[0]);
        int i=0;
        for(i=0; i<inorder.length;i++){
            if(preorder[0]==inorder[i]){
                break;
            }
        }

        int[] leftPreorder=new int[i];
        for(int j=0; j<i;j++){
            leftPreorder[j]=preorder[j+1];
        }

        int[] leftInorder=new int[i];
        for(int j=0; j<i;j++){
            leftInorder[j]=inorder[j];
        }

        int[] rightPreorder=new int[inorder.length-i-1];
        for(int j=0; j<rightPreorder.length;j++){
            rightPreorder[j]=preorder[1+i+j];
        }


        int[] rightInorder=new int[inorder.length-i-1];
        for(int j=0; j<rightInorder.length;j++){
            rightInorder[j]=inorder[i+1+j];
        }

        root.left=buildTree(leftPreorder, leftInorder);
        root.right=buildTree(rightPreorder, rightInorder);

        return root;


    }
}
