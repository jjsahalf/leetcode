package leetcode;

/**
 * Created by yufeijiang on 9/8/16.
 */
public class StrobogrammaticNumberSolution {
    public boolean isStrobogrammatic(String num) {
        if(num ==null || num.equals("")){
            return false;
        }
        int left=0;
        int right=num.length()-1;
        while(left<=right){
            char lChar=num.charAt(left);
            char rChar=num.charAt(right);
            if((lChar=='1' && rChar=='1') || (lChar=='8' && rChar== '8') || (lChar=='6' && rChar== '9') || (lChar=='9' && rChar== '6') || (lChar=='0' && rChar== '0')){
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }
}
