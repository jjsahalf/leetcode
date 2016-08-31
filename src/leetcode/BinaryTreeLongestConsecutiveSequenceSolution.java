package leetcode;

/**
 * Created by yufeijiang on 8/30/16.
 */
public class BinaryTreeLongestConsecutiveSequenceSolution {
    public int longestConsecutive(TreeNode root) {
        if(root==null){
            return 0;
        }
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode root, int local, int globalMax){
        if(root==null){
            return globalMax;
        }
        int rootVal=root.val;
        int expect=rootVal+1;
        int left=0;
        int right=0;
        if(root.left!=null && root.left.val==expect){
            left=dfs(root.left, local+1, Math.max(local+1, globalMax));
        }else{
            left=dfs(root.left, 1, Math.max(1, globalMax));
        }
        if(root.right!=null && root.right.val==expect){
            right=dfs(root.right, local+1, Math.max(local+1, globalMax));
        }else{
            right=dfs(root.right, 1, Math.max(1, globalMax));
        }

        return Math.max(left,right);
    }
}
