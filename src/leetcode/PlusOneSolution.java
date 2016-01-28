package leetcode;

/**
 * Created by yufeijiang on 1/27/16.
 */
public class PlusOneSolution {

    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0){
            return null;
        }

        for(int j=digits.length-1; j>=0;j--){
            if(digits[j]<9){
                digits[j]+=1;
                return digits;
            }else{
                digits[j]=0;
            }
        }

        int[] return_new_array=new int[digits.length+1];
        return_new_array[0]=1;
        for(int i=1;i<return_new_array.length; i++){
            return_new_array[i]=0;
        }

        return return_new_array;

    }
}
