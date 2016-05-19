package leetcode;

/**
 * Created by yufeijiang on 5/18/16.
 */
public class SortColorsSolution {

    /*
    Counting Sort!
     */

    /*
    Two Pointers:
    One Pass Solution!
    1:       void sortColors(int A[], int n) {
2:            // Start typing your C/C++ solution below
3:            // DO NOT write int main() function
4:            int redSt=0, bluSt=n-1;
5:            int i=0;
6:            while(i<bluSt+1)
7:            {
8:                 if(A[i]==0)
9:                 {
10:                      std::swap(A[i],A[redSt]);
11:                      redSt++;
12:                      i++;
13:                      continue;
14:                 }
15:                 if(A[i] ==2)
16:                 {
17:                      std::swap(A[i],A[bluSt]);
18:                      bluSt--;
19:                      continue;
20:                 }
21:                 i++;
22:            }
23:       }
     */


    public class Solution {
        public void sortColors(int[] nums) {
            if(nums==null){
                return;
            }
            if(nums.length==0){
                return;
            }

            int[] counting=new int[3];
            for(int i=0;i<counting.length;i++){
                counting[i]=0;
            }

            for(int i=0; i<nums.length;i++){
                counting[nums[i]]++;
            }

            int index=0;
            for(int i=0;i<counting.length;i++){
                int number=counting[i];
                int j=index;
                for(;index<j+number;index++){
                    nums[index]=i;
                }
            }

            return;
        }
    }
}
