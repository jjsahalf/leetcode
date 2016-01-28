package leetcode;

/**
 * Created by yufeijiang on 1/27/16.
 */
public class LengthOfLastWordSolution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
        s=s.trim();
        String[] string_array=s.split(" ");
        if(string_array==null || string_array.length==0){
            return 0;
        }


        return string_array[string_array.length-1].length();

    }
}
