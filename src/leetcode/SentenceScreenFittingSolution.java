package leetcode;

/**
 * Created by yufeijiang on 11/6/16.
 */
public class SentenceScreenFittingSolution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if(sentence==null || sentence.length==0){
            return 0;
        }
        StringBuilder sb=new StringBuilder();
        for(String str: sentence){
            sb.append(str);
            sb.append(" ");
        }
        String sen=sb.toString();
        char[] array=sen.toCharArray();
        int actualLen=0;
        int row=0;
        int len=sen.length();
        while(row<rows){
            actualLen=actualLen+cols+1;
            if(array[(actualLen-1)%len]==' '){
                row++;
            }else{
                while(actualLen>=1 && array[(actualLen-1)%len]!=' '){
                    actualLen--;
                }
                row++;
            }
        }
        return actualLen/len;
    }
}
