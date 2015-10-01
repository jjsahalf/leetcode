package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 10/1/15.
 */
public class CourseScheduleSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //HashMap
        //精彩！
        if(numCourses<=0){
            return true;
        }
        if(prerequisites==null){
            return true;
        }
        if(prerequisites.length==0){
            return true;
        }

        Map<Integer, Set<Integer>> courseMap=new HashMap<Integer, Set<Integer>>();
        for(int[] coursePair: prerequisites){
            int advancedCourse=coursePair[0];
            int lowLevelCourse=coursePair[1];
            if(courseMap.containsKey(advancedCourse)){
                courseMap.get(advancedCourse).add(lowLevelCourse);
            }else{
                courseMap.put(advancedCourse,new HashSet<Integer>());
                courseMap.get(advancedCourse).add(lowLevelCourse);
            }
        }

        Queue<Integer> sinkVertexQueue=new LinkedList();
        Set keySet=courseMap.keySet();

        for(int i=0; i<numCourses; i++){
            if(!keySet.contains(i)){
                sinkVertexQueue.add(i);
            }
        }

        if(sinkVertexQueue.size()==0){
            return false;
        }

        while(sinkVertexQueue.size()>0){
            Integer aSinkVertex=sinkVertexQueue.poll();
            for(Integer key: courseMap.keySet()){
                if(courseMap.get(key).contains(aSinkVertex)){
                    courseMap.get(key).remove(aSinkVertex);
                    if(courseMap.get(key).size()==0){
                        sinkVertexQueue.add(key);
                    }
                }
            }
        }

        for(Integer key: courseMap.keySet()){
            if(courseMap.get(key).size()>0){
                return false;
            }
        }

        return true;
    }
}
