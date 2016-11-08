package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by yufeijiang on 11/7/16.
 */
public class CreateMaximumNumberSolution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }

        int minFetch=0;
        int maxFetch=0;
        if(k<=nums1.length){
            minFetch=0;
            maxFetch=k;
        }else if(k>nums1.length && k<=nums2.length){
            minFetch=0;
            maxFetch=nums1.length;
        }else{
            minFetch=k-nums2.length;
            maxFetch=nums1.length;
        }

        StringBuilder maxBuilder=new StringBuilder();
        for(int i=0; i<k; i++){
            maxBuilder.append('0');
        }
        String max=maxBuilder.toString();

        for(int i=minFetch; i<=maxFetch; i++){
            List<Integer> list1=findBiggest(nums1, i);
            List<Integer> list2=findBiggest(nums2, k-i);
            String local=merge(list1, list2);
            int diff=max.compareTo(local);
            if(diff<0){
                max=local;
            }
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=Integer.parseInt(String.valueOf(max.charAt(i)));
        }
        return res;
    }

    public String merge(List<Integer> list1, List<Integer> list2){
        StringBuilder sb=new StringBuilder();
        int index1=0;
        int index2=0;
        while(index1<list1.size() || index2<list2.size()){
            if(greater(list1, index1, list2, index2)){
                sb.append(list1.get(index1));
                index1++;
            }else{
                sb.append(list2.get(index2));
                index2++;
            }
        }
        return sb.toString();
    }

    private boolean greater(List<Integer> list1, int index1, List<Integer> list2, int index2){
        while(index1<list1.size() && index2<list2.size()){
            if(list1.get(index1)==list2.get(index2)){
                index1++;
                index2++;
            }else if(list1.get(index1)>list2.get(index2)){
                return true;
            }else{
                return false;
            }
        }
        if(index2==list2.size()){
            return true;
        }
        return false;
    }

    public List<Integer> findBiggest(int[] nums, int k){
        Stack<Integer> stack=new Stack();
        int remainingPop=nums.length-k;
        int index=0;
        while(index<nums.length){
            if(remainingPop>0){
                if(stack.isEmpty() || stack.peek()>=nums[index] ){
                    stack.push(nums[index]);
                    index++;
                }else{
                    stack.pop();
                    remainingPop--;
                }
            }else{
                stack.push(nums[index]);
                index++;
            }
        }
        while(remainingPop>0){
            stack.pop();
            remainingPop--;
        }
        List<Integer> list=new ArrayList();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.reverse(list);
        return list;
    }
}
