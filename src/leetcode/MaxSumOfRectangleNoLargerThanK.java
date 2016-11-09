package leetcode;

import java.util.TreeSet;

/**
 * Created by yufeijiang on 11/9/16.
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for(int L=0; L<matrix[0].length;L++){
            int[] temp=new int[matrix.length];
            for(int R=L;R<matrix[0].length;R++){
                TreeSet<Integer> set=new TreeSet();
                set.add(0); //I guess this is important
                int[] cum=new int[matrix.length+1];
                for(int i=0; i<matrix.length; i++){
                    temp[i]+=matrix[i][R];
                    //System.out.println(temp[i]);

                }
                int sum=0;
                for(int j=0; j<matrix.length;j++){
                    cum[j]=sum+temp[j];
                    sum=cum[j];
                    Integer prefix=set.ceiling(Integer.valueOf(cum[j]-k));
                    if(prefix!=null){
                        max=Math.max(cum[j]-prefix, max);
                    }
                    set.add(cum[j]);
                }
            }
        }
        return max;
    }
}
