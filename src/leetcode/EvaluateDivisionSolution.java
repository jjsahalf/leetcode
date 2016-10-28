package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yufeijiang on 10/27/16.
 */
public class EvaluateDivisionSolution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(equations==null || equations.length==0 || equations[0].length==0 || values==null || values.length==0 || queries==null || queries.length==0 || queries[0].length==0){
            return null;
        }
        Set<String> set=new HashSet();
        for(int i=0;i<equations.length;i++){
            set.add(equations[i][0]);
            set.add(equations[i][1]);
        }
        Map<String,Integer> map=new HashMap();
        int counter=0;
        for(String str:set){
            map.put(str,counter);
            counter++;
        }
        int variableNum=set.size();
        double[][] closure=new double[variableNum][variableNum];
        for(int i=0; i<variableNum;i++){
            closure[i][i]=1;
        }
        for(int i=0;i<equations.length;i++){
            closure[map.get(equations[i][0])][map.get(equations[i][1])]=values[i];
            closure[map.get(equations[i][1])][map.get(equations[i][0])]=1/values[i];
        }
        for(int k=0;k<closure.length;k++){
            for(int i=0;i<closure.length;i++){
                for(int j=0; j<closure.length;j++){
                    if(i==j || i==k || j==k){
                        continue;
                    }
                    if(closure[i][j]!=0){
                        continue;
                    }
                    if(closure[i][k]!=0 && closure[k][j]!=0){
                        closure[i][j]=closure[i][k] * closure[k][j];
                    }
                }
            }
        }
        double[] res=new double[queries.length];
        for(int i=0;i<res.length;i++){
            if(map.containsKey(queries[i][0]) && map.containsKey(queries[i][1]) ){
                if(closure[map.get(queries[i][0])][map.get(queries[i][1])]!=0){
                    res[i]=closure[map.get(queries[i][0])][map.get(queries[i][1])];
                }else{
                    res[i]=-1;
                }
            }else{
                res[i]=-1;
            }

        }
        return res;
    }
}
