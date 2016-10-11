package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 10/10/16.
 */
public class SparseMatrixMultiplicationSolution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res=new int[A.length][B[0].length];
        Map<Integer, Map<Integer, Integer>> map=new HashMap();
        for(int k=0;k<B.length;k++){
            for(int j=0; j<B[0].length;j++){
                if(B[k][j]!=0){
                    if(map.containsKey(k)){
                        map.get(k).put(j, B[k][j]);
                    }else{
                        Map<Integer, Integer> smallMap=new HashMap();
                        smallMap.put(j, B[k][j]);
                        map.put(k,smallMap);
                    }
                }
            }
        }
        for(int i=0; i<A.length;i++){
            for(int k=0;k<A[0].length; k++){
                if(A[i][k]!=0){
                    if(map.containsKey(k)){
                        Map<Integer, Integer> smallMap=map.get(k);
                        for(int bCol: smallMap.keySet()){
                            res[i][bCol]+=A[i][k]*B[k][bCol];
                        }
                    }
                }
            }
        }
        return res;
    }
}
