package leetcode;

/**
 * Created by yufeijiang on 8/25/16.
 */
public class ReverseWordsInAStringIISolution {
    public void reverseWords(char[] s) {
        if(s==null || s.length==0){
            return;
        }
        int wordStart=0;
        int wordEnd=0;
        int mover=0;
        while(mover<s.length){
            if(s[mover]==' '){
                wordEnd=mover-1;
                swap(s, wordStart, wordEnd);
                wordStart=mover+1;
            }
            mover++;
        }
        wordEnd=s.length-1;
        swap(s, wordStart, wordEnd);
        swap(s, 0, s.length-1);
    }
    public void swap(char[] s, int startPos, int endPos){
        while(startPos<endPos){
            char temp=s[startPos];
            s[startPos]=s[endPos];
            s[endPos]=temp;
            startPos++;
            endPos--;
        }
    }
}
