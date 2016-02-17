package leetcode;

/**
 * Created by yufeijiang on 2/17/16.
 */
public class RangeSumQuerySolution {


    private int[] sums;


    public RangeSumQuerySolution(int[] nums) {
        int sum=0;
        sums=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sums[i]=sum;
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return sums[j];
        }else{
            return sums[j]-sums[i-1];
        }
    }



    /*

    private int[] inNums;
    private Map<Integer, Integer>[] mapArray;


    public NumArray(int[] nums) {
        inNums=nums;
        mapArray=new HashMap[nums.length];
    }

    public int sumRange(int i, int j) {
        if(mapArray[i]==null){
            int sum=0;
            for(int counter=i;counter<=j;counter++){
                sum+=inNums[counter];
            }
            Map<Integer, Integer> map=new HashMap();
            map.put(j, sum);
            mapArray[i]=map;
            propagation(i,j);
            return sum;
        }else{
            if(mapArray[i].containsKey(j)){
                return mapArray[i].get(j);
            }else{
                int sum=0;
                for(int counter=i;counter<=j;counter++){
                    sum+=inNums[counter];
                }
                mapArray[i].put(j,sum);
                propagation(i,j);
                return sum;
            }
        }
    }


    public void propagation(int i, int j){
        for(int counter=0; counter<i; counter++){
            if(mapArray[counter]==null){
                continue;
            }else{
                if(mapArray[counter].containsKey(i-1)){
                    if(mapArray[counter].containsKey(j)){
                        continue;
                    }else{
                        int bigSum=mapArray[counter].get(i-1)+mapArray[i].get(j);
                        mapArray[counter].put(j,bigSum);
                        propagation(counter, j);
                    }
                }
            }
        }
        if(j==mapArray.length-1){
            return;
        }

        if(mapArray[j+1]==null){
            return;
        }

        for(Map.Entry<Integer, Integer> entry:mapArray[j+1].entrySet()){
            if(mapArray[i].containsKey(entry.getKey())){
                continue;
            }else{
                int bigSum=mapArray[i].get(j)+mapArray[j+1].get(entry.getKey());
                mapArray[i].put(entry.getKey(), bigSum);
                propagation(i,entry.getKey());
            }
        }



    }
     */
}
