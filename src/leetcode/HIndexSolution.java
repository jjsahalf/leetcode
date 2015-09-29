package leetcode;

import java.util.Arrays;

/**
 * Created by yufeijiang on 9/29/15.
 */
public class HIndexSolution {
    public int hIndex(int[] citations) {
        if(citations==null){
            return 0;
        }
        if(citations.length==0){
            return 0;
        }
        Arrays.sort(citations);
        int size=citations.length;
        int hPaperCounter=1;
        for(hPaperCounter=1;hPaperCounter<=size;hPaperCounter++){
            if(hPaperCounter==citations[size-hPaperCounter]){
                return hPaperCounter;
            }
            if(hPaperCounter>citations[size-hPaperCounter]){
                return hPaperCounter-1;
            }
        }
        return hPaperCounter-1;
    }
}
