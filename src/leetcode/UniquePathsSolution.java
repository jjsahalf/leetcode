package leetcode;

/**
 * Created by yufeijiang on 5/6/16.
 */
public class UniquePathsSolution {
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

    }
}
