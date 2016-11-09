package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 11/9/16.
 */
public class MinimumHeightTreesSolution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list=new ArrayList();
        Map<Integer, Set<Integer>> map=new HashMap();
        int[] degree=new int[n];
        if(n==0){
            return list;
        }
        if(edges==null || edges.length==0 || edges[0].length==0){
            list.add(0);
            return list;
        }
        for(int i=0; i<edges.length; i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            degree[v1]++;
            degree[v2]++;
            if(map.containsKey(v1)){
                map.get(v1).add(v2);
            }else{
                Set temp=new HashSet();
                temp.add(v2);
                map.put(v1, temp);
            }
            if(map.containsKey(v2)){
                map.get(v2).add(v1);
            }else{
                Set temp=new HashSet();
                temp.add(v1);
                map.put(v2, temp);
            }
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0; i<degree.length;i++){
            if(degree[i]==1){
                queue.offer(i);
            }
        }
        while(map.size()>2){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curr=queue.poll();
                degree[curr]--;
                Set<Integer> temp=map.get(curr);
                for(Integer j:temp){
                    degree[j]--;
                    map.get(j).remove(curr);
                    if(degree[j]==1){
                        queue.offer(j);
                    }
                }
                map.remove(curr);
            }
        }
        for(int res:map.keySet()){
            list.add(res);
        }
        return list;
    }
}
