package leetcode;

/**
 * Created by yufeijiang on 2/14/16.
 */
public class FirstBadVersion {

    /*
    Binary Search
    To avoid overflow integer,
    do not use (first+end)/2
    use first+(end-first)/2;
     */

    /*
    public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n==1){
            return n;
        }

        if(isBadVersion(1)){
            return 1;
        }else{
            return recursiveFinder(1,n);
        }
    }

    protected int recursiveFinder(int first, int end){
        if(end-first<=1){
            return end;
        }
        int mid=first+(end-first)/2;
        if(isBadVersion(mid)){
            return recursiveFinder(first,mid);
        }else{
            return recursiveFinder(mid, end);
        }
        //return -1;
    }

}
     */
}
