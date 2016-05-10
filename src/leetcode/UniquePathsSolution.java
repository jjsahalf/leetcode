package leetcode;

/**
 * Created by yufeijiang on 5/6/16.
 */
public class UniquePathsSolution {


    /*
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        if(n>m){
            int temp=m;
            m=n;
            n=temp;
        }
        int step=m+n;
        long division=1;
        for(int i=m+1;i<=step;i++){
            division*=i;
        }

        long product=1;
        for(int j=1;j<=n;j++){
            product*=j;
        }

        return (int)(division/product);

    }*/
    //We should use DP.

    public int uniquePaths(int m, int n) {

        if(m==0 || n==0){
            return 0;
        }

        if(m==1 || n==1){
            return 1;
        }

        int[][] matrix= new int[m][n];

        for(int i=0; i<n;i++){
            matrix[0][i]=1;
        }

        for(int j=0; j<m;j++){
            matrix[j][0]=1;
        }

        for(int mCounter=1; mCounter<m; mCounter++){
            for(int nCounter=1; nCounter<n; nCounter++){
                matrix[mCounter][nCounter]=matrix[mCounter-1][nCounter]+matrix[mCounter][nCounter-1];
            }
        }

        return matrix[m-1][n-1];

    }


}
