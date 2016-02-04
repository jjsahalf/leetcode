package leetcode;

/**
 * Created by yufeijiang on 2/3/16.
 */
public class ExcelSheetColumnNumberSolution {
    public int titleToNumber(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
        int sum=0;
        for(int i=0; i<s.length();i++){
            char currentChar=s.charAt(i);
            int diff=(int)(currentChar-'A'+1);
            sum=sum*26+diff;
        }

        return sum;

    }
}
