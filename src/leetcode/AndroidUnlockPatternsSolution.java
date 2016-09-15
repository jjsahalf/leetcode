package leetcode;

/**
 * Created by yufeijiang on 9/14/16.
 */
public class AndroidUnlockPatternsSolution {
    public int numberOfPatterns(int m, int n) {
        if(m<1 || m>9 || n<1 || n>9 || m>n){
            return 0;
        }
        boolean[] visited=new boolean[10];
        visited[0]=true;
        int[][] pad=new int[10][10];
        pad[1][3]=pad[3][1]=2;
        pad[1][7]=pad[7][1]=4;
        pad[3][9]=pad[9][3]=6;
        pad[7][9]=pad[9][7]=8;
        pad[1][9]=pad[9][1]=pad[7][3]=pad[3][7]=pad[2][8]=pad[8][2]=pad[4][6]=pad[6][4]=5;
        return helper(m,n, 1,1, visited, pad)*4+helper(m,n,1,2,visited, pad)*4+helper(m,n,1,5,visited, pad);

    }
    public int helper(int m, int n, int len, int num, boolean[] visited, int[][] pad){
        visited[num]=true;
        int counter=0;
        if(len>=m){
            counter++;
        }
        if(len==n){
            visited[num]=false;
            return counter;
        }else{
            for(int i=1;i<=9;i++){
                if(!visited[i] && visited[pad[num][i]]){
                    counter+=helper(m,n,len+1,i,visited, pad);
                }
            }
            visited[num]=false;
            return counter;
        }
    }
}
