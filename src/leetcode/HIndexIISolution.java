package leetcode;

/**
 * Created by yufeijiang on 9/12/16.
 */
public class HIndexIISolution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0){
            return 0;
        }
        int left=0;
        int hIndex=0;
        int right=citations.length-1;
        while(left+1<right){
            int mid=(left+right)/2;
            if(citations[mid]>=citations.length-mid){
                hIndex=Math.max(hIndex, citations.length-mid);
                right=mid;
            }else{
                left=mid;
            }
        }
        if(citations[left]>=citations.length-left){
            hIndex=Math.max(hIndex, citations.length-left);
        }
        if(citations[right]>=citations.length-right){
            hIndex=Math.max(hIndex, citations.length-right);
        }
        return hIndex;
    }
}
