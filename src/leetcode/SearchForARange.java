package leetcode;

/**
 * Created by yufeijiang on 2/22/16.
 */
public class SearchForARange {

    /*

    This one is different


    public int[] searchRange(int[] A, int target) {
        int [] res = {-1,-1};
        if(A == null || A.length == 0)
            return res;

        //first iteration, find target wherever it is
        int low = 0;
        int high = A.length-1;
        int pos = 0;
        while(low <= high){
            int mid = (low + high)/2;
            pos = mid;
            if(A[mid] > target)
                high = mid - 1;
            else if(A[mid] < target)
                low = mid + 1;
            else{
                res[0] = pos;
                res[1] = pos;
                break;
            }
        }

        if(A[pos] != target)
            return res;

        //second iteration, find the right boundary of this target
        int newlow = pos;
        int newhigh = A.length-1;
        while(newlow <= newhigh){
            int newmid = (newlow+newhigh)/2;
            if(A[newmid] == target)
                newlow = newmid + 1;
            else
                newhigh = newmid - 1;
        }
        res[1] = newhigh;

        //third iteration, find the left boundary of this target
        newlow = 0;
        newhigh = pos;
        while(newlow <= newhigh){
            int newmid = (newlow+newhigh)/2;
            if(A[newmid] == target)
                newhigh = newmid - 1;
            else
                newlow = newmid + 1;
        }
        res[0] = newlow;

        return res;
    }



     */





    public int[] searchRange(int[] nums, int target) {
        if(nums==null){
            int[] array={-1,-1};
            return array;
        }
        if(nums.length==0){
            int[] array={-1,-1};
            return array;
        }
        if(target<nums[0]){
            int[] array={-1,-1};
            return array;
        }
        if(target>nums[nums.length-1]){
            int[] array={-1,-1};
            return array;
        }

        int[] left=helper(nums, 0, (nums.length-1)/2,target);
        int[] right=helper(nums, (nums.length-1)/2+1, nums.length-1, target);

        if(left[0]==-1){
            return right;
        }
        if(right[0]==-1){
            return left;
        }
        int[] combinedArray={left[0],right[1]};
        return combinedArray;
    }

    protected int[] helper(int[] nums, int start, int end, int target){
        if(start>end){
            int[] array={-1,-1};
            return array;
        }
        if(start==end){
            if(nums[start]==target){
                int[] array={start,end};
                return array;
            }else{
                int[] array={-1,-1};
                return array;
            }
        }

        if(target>=nums[start] && target<=nums[end]){
            int[] left=helper(nums, start, (start+end)/2,target);
            int[] right=helper(nums,(start+end)/2+1,end,target);
            if(left[0]==-1){
                return right;
            }
            if(right[0]==-1){
                return left;
            }
            int[] combinedArray={left[0],right[1]};
            return combinedArray;

        }else{
            int[] array={-1,-1};
            return array;
        }
    }
}
