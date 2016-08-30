package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 8/30/16.
 */
public class CourseScheduleIISolution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //handling exceptions
        int[] res=new int[numCourses];
        if(numCourses==0){
            return res;
        }
        if(prerequisites==null || prerequisites.length==0){
            for(int i=0; i<numCourses; i++){
                res[i]=i;
            }
            return res;
        }
        //preprocessing
        List<Set<Integer>> list=new ArrayList();
        for(int i=0; i<numCourses;i++){
            list.add(new HashSet());
        }

        for(int i=0;i<prerequisites.length;i++){
            int advancedCourse=prerequisites[i][0];
            int lowLevelCourse=prerequisites[i][1];
            list.get(lowLevelCourse).add(advancedCourse);
        }

        int[] inDegree =new int[numCourses];
        for(Set<Integer> set:list){
            for(Integer i:set){
                inDegree[i]++;
            }
        }

        //find starting points(sinkVertices)
        Queue<Integer> queue=new LinkedList();
        for(int i=0; i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        //build course schedule
        int index=0;
        while(!queue.isEmpty()){
            int aCourseYouCanTakeNow=queue.poll();
            res[index]=aCourseYouCanTakeNow;
            index++;
            Set<Integer> advanedSet=list.get(aCourseYouCanTakeNow);
            for(int i:advanedSet){
                inDegree[i]--;
                if(inDegree[i]==0){
                    queue.offer(i);
                }
            }
        }
        if(index==numCourses){
            return res;
        }else{
            res=new int[0];
            return res;
        }
    }
}
