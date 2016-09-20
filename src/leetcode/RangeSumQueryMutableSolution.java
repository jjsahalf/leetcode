package leetcode;

/**
 * Created by yufeijiang on 9/20/16.
 */
public class RangeSumQueryMutableSolution {

    private int[] binaryIndexTree;
    private int[] array;

    public RangeSumQueryMutableSolution(int[] nums) {
        array=new int[nums.length];
        binaryIndexTree=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            array[i]=nums[i];
        }
        for(int i=1;i<=nums.length;i++){
            int lowbit=lowbit(i);
            int sum=0;
            for(int j=0;j<lowbit;j++){
                sum+=array[i-j-1];
            }
            binaryIndexTree[i]=sum;
        }
    }

    void update(int i, int val) {
        int diff=val-array[i];
        array[i]=val;
        for(int j=i+1;j<=array.length;j+=j&(-j)){
            binaryIndexTree[j]+=diff;
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j+1)-getSum(i);
    }

    private int getSum(int index){
        int sum=0;
        for(int i=index;i>0;i-=i&(-i)){
            sum+=binaryIndexTree[i];
        }
        return sum;
    }

    private int lowbit(int num){
        return num & (-num);
    }
}
