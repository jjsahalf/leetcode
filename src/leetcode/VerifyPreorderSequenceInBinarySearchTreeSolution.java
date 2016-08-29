package leetcode;

/**
 * Created by yufeijiang on 8/29/16.
 */

public class VerifyPreorderSequenceInBinarySearchTreeSolution {



    /*
        public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stk = new Stack<Integer>();
        // 初始化最小值为最小整数
        int min = Integer.MIN_VALUE;
        for(int num : preorder){
            // 违反最小值限定则是无效的
            if(num < min) return false;
            // 将路径中所有小于当前的数pop出来并更新最小值
            while(!stk.isEmpty() && num > stk.peek()){
                min = stk.pop();
            }
            // 将当前值push进去
            stk.push(num);
        }
        return true;
    }
     */




    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null || preorder.length==0){
            return true;
        }
        return helper(preorder, 0, preorder.length-1);
    }
    public boolean helper(int[] preorder, int start, int end){
        if(start==end){
            return true;
        }
        int root=preorder[start];
        int i=0;
        int j=0;
        int leftStart=0;
        int leftEnd=0;
        for(i=start+1;i<=end;i++){
            if(preorder[i]<root){
                continue;
            }else{
                break;
            }
        }
        boolean hasLeftTree=false;
        boolean hasRightTree=false;
        if(i==start+1){
            hasLeftTree=false;
        }else{
            leftStart=start+1;
            leftEnd=i-1;
            hasLeftTree=true;
        }

        if(i==end+1){
            hasRightTree=false;
        }else{
            hasRightTree=true;
            for(j=i; j<=end;j++){
                if(preorder[j]>root){
                    continue;
                }else{
                    break;
                }
            }
        }
        if(hasRightTree && j!=end+1){
            return false;
        }else{
            if(hasLeftTree && hasRightTree){
                return helper(preorder, leftStart, leftEnd) && helper(preorder, leftEnd+1,end);
            }else if(hasLeftTree){
                return helper(preorder, leftStart, leftEnd);
            }else if(hasRightTree){
                return helper(preorder, start+1, end);
            }
        }
        return false;
    }
}
