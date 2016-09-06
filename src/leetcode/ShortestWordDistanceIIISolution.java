package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 9/6/16.
 */
public class ShortestWordDistanceIIISolution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minDistance=Integer.MAX_VALUE;
        if(!word1.equals(word2)){
            int pos1=-1;
            int pos2=-1;
            for(int i=0; i<words.length;i++){
                if(words[i].equals(word1)){
                    pos1=i;
                    if(pos2!=-1){
                        int local=Math.abs(pos1-pos2);
                        minDistance=Math.min(local, minDistance);
                    }
                }
                if(words[i].equals(word2)){
                    pos2=i;
                    if(pos1!=-1){
                        int local=Math.abs(pos1-pos2);
                        minDistance=Math.min(local, minDistance);
                    }
                }
            }
        }else{
            List<Integer> list=new ArrayList();
            int next=-1;
            int prev=-1;
            for(int i=0;i<words.length;i++){
                if(words[i].equals(word1)){
                    prev=next;
                    next=i;
                    if(prev!=-1){
                        int local=next-prev;
                        minDistance=Math.min(local,minDistance);
                    }
                }
            }
        }
        return minDistance;
    }
}
