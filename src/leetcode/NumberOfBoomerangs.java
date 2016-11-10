package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 11/9/16.
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if(points==null || points.length==0 || points[0].length==0){
            return 0;
        }
        if(points.length<3){
            return 0;
        }
        int res=0;
        for(int i=0;i<points.length; i++){
            //select each point as center
            int currX=points[i][0];
            int currY=points[i][1];
            Map<Integer, Integer> map=new HashMap();
            for(int j=0; j<points.length; j++){
                //select every other point
                if(i==j){
                    continue;
                }
                int otherX=points[j][0];
                int otherY=points[j][1];
                int distance= (currX-otherX)*(currX-otherX) + (currY-otherY)*(currY-otherY);
                if(!map.containsKey(distance)){
                    map.put(distance, 1);
                }else{
                    res+=map.get(distance)*2;
                    map.put(distance, map.get(distance)+1);
                }
            }
        }
        return res;
    }
}
