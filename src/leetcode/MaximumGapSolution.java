package leetcode;

import java.util.Arrays;

//this solution is from
//https://oj.leetcode.com/discuss/18499/bucket-sort-java-solution-with-explanation-o-time-and-space?show=18499#q18499
public class MaximumGapSolution {
	private int smallest;
	private int largest;
	private int max_no_smaller_than_this;
	
	public int maximumGap(int[] num) {
		if(num==null||num.length<2){
			return 0;
		}
		
		smallest=num[0];
		largest=num[0];
		
		for(int i:num){
			smallest=Math.min(smallest, i);
			largest=Math.max(largest, i);
		}
		
		//we must use ceil here, because 
		//we must have (n-1)*MaxGap>=OverallGap
		//if we use floor here, we might have (n-1)*MaxGap<OverallGap
		//which is incorrect.
		max_no_smaller_than_this=
				(int)Math.ceil((double)(largest - smallest)/(num.length - 1));
		
		int[] bucket_min_array=new int[num.length-1];
		int[] bucket_max_array=new int[num.length-1];
		
		//a quick and a good way to fill an array;
		Arrays.fill(bucket_min_array, Integer.MAX_VALUE);
		Arrays.fill(bucket_max_array, Integer.MIN_VALUE);
		
		int k=0;
		for(int i:num){
			if(i==smallest||i==largest){
				continue;
			}
			k=(i-smallest)/max_no_smaller_than_this;
			bucket_min_array[k]=Math.min(bucket_min_array[k], i);
			bucket_max_array[k]=Math.max(bucket_max_array[k], i);
		}
		
		int previous=smallest;
		int max_gap=Integer.MIN_VALUE;
		
		for(int bucket_index=0;bucket_index<num.length-1;bucket_index++){
			//chcek if a bucket is empty first
			//there is at least one. max gap will step over that
			//so no need to check in the bucket.
			if(bucket_min_array[bucket_index]==Integer.MAX_VALUE &&
					bucket_max_array[bucket_index]==Integer.MIN_VALUE){
				continue;
			}
			
			max_gap=Math.max(bucket_min_array[bucket_index]-previous,max_gap);
			previous=bucket_max_array[bucket_index];
				
		}
		//don't forget this.
		max_gap=Math.max(largest-previous,max_gap);
		
		
        return max_gap;
    }
	
	
	

}
