package leetcode;

/**
 * Created by yufeijiang on 9/1/16.
 */
public class ShortestWordDistanceSolution {

    /*
        public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, distance = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                idx1 = i;
                // 第一次写入idx就先不比较
                if(idx2 != -1) distance = Math.min(distance, idx1 - idx2);
            }
            if(words[i].equals(word2)){
                idx2 = i;
                // 第一次写入idx就先不比较
                if(idx1 != -1) distance = Math.min(distance, idx2 - idx1);
            }
        }
        return distance;
    }
     */

    public int shortestDistance(String[] words, String word1, String word2) {
        if(words==null || words.length==0 || word1==null || word1.equals("") || word2==null || word2.equals("")){
            return -1;
        }
        int word1Pos=-1;
        int word2Pos=-1;
        int minDistance=Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)){
                word1Pos=i;
            }
            if(words[i].equals(word2)){
                word2Pos=i;
            }
            if(word1Pos!=-1 && word2Pos!=-1){
                int localDistance=Math.abs(word1Pos-word2Pos);
                minDistance=Math.min(minDistance, localDistance);
            }
        }
        return minDistance;
    }
}
