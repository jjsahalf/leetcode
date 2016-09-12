package leetcode;

/**
 * Created by yufeijiang on 9/11/16.
 */
public class NumberofConnectedComponentsinanUndirectedGraphSolution {
    public boolean validTree(int n, int[][] edges) {
        if(n<=1){
            return true;
        }
        if(edges==null || edges.length==0){
            return false;
        }
        int[] uf=new int[n];
        for(int i=0;i<n;i++){
            uf[i]=i;
        }
        int counter=n;
        for(int[] e:edges){
            int node1=e[0];
            int node2=e[1];
            if(uf[node1]==uf[node2]){
                return false;
            }else{
                int majorGroupNumber=uf[node1];
                int groupNumber=uf[node2];
                for(int i=0;i<n;i++){
                    if(uf[i]==groupNumber){
                        uf[i]=majorGroupNumber;
                    }
                }
                counter--;
            }
        }
        if(counter==1){
            return true;
        }else{
            return false;
        }
    }
}
