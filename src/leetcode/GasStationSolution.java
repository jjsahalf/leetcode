package leetcode;

/**
 * Created by yufeijiang on 7/26/16.
 */
public class GasStationSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null || gas.length==0){
            return -1;
        }
        int length=gas.length;
        for(int i=0;i<gas.length;i++){
            int tank=0;
            int j;
            for(j=i; j<gas.length+i;j++){
                tank+=(gas[j%length]-cost[j%length]);
                if(tank<0){
                    break;
                }
            }
            if(j==gas.length+i){
                return i;
            }else{
                i=j;
            }
        }
        return -1;
    }
}
