package leetcode;

/**
 * Created by yufeijiang on 11/8/16.
 */
public class RangeAdditionSolution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if(length==0){
            return null;
        }
        int[] res=new int[length];
        if(updates==null || updates.length==0 || updates[0].length==0){
            return res;
        }
        for(int i=0; i<updates.length; i++){
            res[updates[i][0]]+=updates[i][2];
            if(updates[i][1]+1<res.length){
                res[updates[i][1]+1]+=-updates[i][2];
            }
        }
        for(int i=1; i<res.length; i++){
            res[i]+=res[i-1];
        }
        return res;
    }
}
