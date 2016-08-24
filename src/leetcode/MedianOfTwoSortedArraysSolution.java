package leetcode;

/**
 * Created by yufeijiang on 8/24/16.
 */
public class MedianOfTwoSortedArraysSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total=nums1.length+nums2.length;
        if(total%2==1){
            return findKth(nums1, 0, nums2, 0, total/2+1);
        }else{
            return (findKth(nums1, 0, nums2,0, total/2)+findKth(nums1, 0, nums2, 0, total/2+1))/2.0;
        }
    }

    public double findKth(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1>=nums1.length){
            return nums2[start2+k-1];
        }
        if(start2>=nums2.length){
            return nums1[start1+k-1];
        }
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int nums1MidValue=start1+k/2-1<nums1.length?nums1[start1+k/2-1]:Integer.MAX_VALUE;
        int nums2MidValue=start2+k/2-1<nums2.length?nums2[start2+k/2-1]:Integer.MAX_VALUE;
        if(nums1MidValue<nums2MidValue){
            return findKth(nums1, start1+k/2, nums2,start2, k-k/2);
        }else{
            return findKth(nums1, start1, nums2, start2+k/2, k-k/2);
        }

    }
}
