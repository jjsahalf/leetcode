package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 2/13/16.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list=new ArrayList();
        List<String> leftPath=new ArrayList();
        List<String> rightPath=new ArrayList();
        if(root==null){
            return list;
        }

        Integer integer=root.val;

        if(root.left==null && root.right==null){
            list.add(integer.toString());
            return list;
        }else{
            if(root.left!=null){
                leftPath=binaryTreePaths(root.left);
            }
            if(root.right!=null){
                rightPath=binaryTreePaths(root.right);
            }
        }
        for(int i=0;i<leftPath.size();i++){
            String patialPath=leftPath.get(i);
            String newString=integer.toString()+"->"+patialPath;
            leftPath.set(i,newString);
        }

        for(int j=0;j<rightPath.size();j++){
            String patialPath=rightPath.get(j);
            String newString=integer.toString()+"->"+patialPath;
            rightPath.set(j,newString);
        }
        leftPath.addAll(rightPath);

        return leftPath;
    }
}
