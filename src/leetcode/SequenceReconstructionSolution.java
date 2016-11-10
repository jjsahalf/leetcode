package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 11/9/16.
 */
public class SequenceReconstructionSolution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if(seqs==null || seqs.length==0 ){
            return false;
        }
        //topological sort
        Map<Integer, List<Integer>> map=new HashMap();
        Map<Integer, Integer> inDegreeMap=new HashMap();
        for(int i=0; i<seqs.length; i++){
            int[] curr=seqs[i];
            if(curr.length==1){
                if(!map.containsKey(curr[0])){
                    map.put(curr[0], new ArrayList());
                }
                if(!inDegreeMap.containsKey(curr[0])){
                    inDegreeMap.put(curr[0],0);
                }
            }
            for(int j=0; j<curr.length-1; j++){
                int source=curr[j];
                int sink=curr[j+1];
                //update edge
                if(map.containsKey(source)){
                    map.get(source).add(sink);
                    //map.put(source, map.get(source).add(sink));
                }else{
                    List<Integer> list=new ArrayList();
                    list.add(sink);
                    map.put(source, list);
                }
                if(!map.containsKey(sink)){
                    map.put(sink, new ArrayList());
                }
                //update inDegree
                if(!inDegreeMap.containsKey(source)){
                    inDegreeMap.put(source, 0);
                }
                if(!inDegreeMap.containsKey(sink)){
                    inDegreeMap.put(sink,1);
                }else{
                    inDegreeMap.put(sink, inDegreeMap.get(sink)+1);
                }
            }
        }
        if(inDegreeMap.size()!=org.length){
            return false;
        }
        List<Integer> list=new ArrayList();
        Queue<Integer> queue=new LinkedList();
        for(Map.Entry<Integer, Integer> entry:inDegreeMap.entrySet() ){
            if(entry.getValue()==0){
                queue.offer(entry.getKey());
            }
        }
        while(!queue.isEmpty()){
            if(queue.size()>1){
                return false;
            }else{
                int curr=queue.poll();
                list.add(curr);
                List<Integer> sinkList=map.get(curr);
                for(Integer sink:sinkList){
                    int inDegree=inDegreeMap.get(sink);
                    inDegree--;
                    if(inDegree==0){
                        queue.offer(sink);
                    }
                    inDegreeMap.put(sink, inDegree);
                }
            }
        }
        if(list.size()!=org.length){
            return false;
        }
        for(int i=0; i<org.length; i++){
            if(org[i]!=list.get(i)){
                return false;
            }
        }
        return true;
    }
}
