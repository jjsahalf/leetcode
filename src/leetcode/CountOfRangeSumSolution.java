package leetcode;

/**
 * Created by yufeijiang on 10/28/16.
 */
public class CountOfRangeSumSolution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null || nums.length==0){
            return 0;
        }
        long[] sum=new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=sum[i]+nums[i];
        }
        return countMergeSort(sum,0,sum.length, lower, upper);
    }
    public int countMergeSort(long[] sums, int start, int end, int lower, int upper){
        if(start+1>=end){
            return 0;
        }
        int mid=(start+end)/2;
        int res=countMergeSort(sums,start,mid,lower,upper)+countMergeSort(sums,mid,end,lower,upper);
        int rightIndex=mid;
        long[] copy=new long[end-start];
        int copyIndex=0;
        int lowerBound=mid;
        int upperBound=mid;
        for(int leftIndex=start; leftIndex<mid;leftIndex++){
            while(lowerBound<end && sums[lowerBound]-sums[leftIndex]<lower){
                lowerBound++;
            }
            while(upperBound<end && sums[upperBound]-sums[leftIndex]<=upper){
                upperBound++;
            }
            while(rightIndex<end && sums[rightIndex]<sums[leftIndex]){
                copy[copyIndex]=sums[rightIndex];
                rightIndex++;
                copyIndex++;
            }
            copy[copyIndex]=sums[leftIndex];
            copyIndex++;
            res+=upperBound-lowerBound;

        }
        System.arraycopy(copy, 0, sums, start, rightIndex-start);
        return res;
    }
}
