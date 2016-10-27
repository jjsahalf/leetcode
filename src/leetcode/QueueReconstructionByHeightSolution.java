package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yufeijiang on 10/26/16.
 */
public class QueueReconstructionByHeightSolution {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null || people.length==0){
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                return b[0]-a[0];
            }
        });
        List<int[]> list=new LinkedList();
        for(int i=0; i<people.length;i++){
            list.add(people[i][1],people[i]);
        }
        int[][] res=new int[people.length][2];
        for(int i=0; i<res.length;i++){
            res[i][0]=list.get(i)[0];
            res[i][1]=list.get(i)[1];
        }
        return res;

    }
}
