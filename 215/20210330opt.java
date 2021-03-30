import java.util.*;
class Solution {
    private static Random random = new Random();
    int ans=-1;
    public int findKthLargest(int[] nums, int k) {
        int left=0;
        int right=nums.length-1;
        sort(nums,left,right,k);
        return ans;
    }
    
    private void sort(int[] nums,int left,int right,int k){
        if(left==right){
            ans=nums[left];
            return;
        }
        if(left>right){
            return;
        }
        randomNum(nums,left,right);
        int pivot=nums[left];
        int i=left;
        int j=right;
        while(i<j){
            while(i<j&&nums[j]>=pivot){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]<=pivot){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=pivot;
        if(nums.length-i==k){
            ans=pivot;
            return;
        }else if(nums.length-i>k){
            sort(nums,i+1,right,k);
        }else{
            sort(nums,left,i-1,k);
        }
    }

    private void randomNum(int[] nums, int left, int right) {
        if (left < right) {
            int r = left + random.nextInt(right - left) + 1;
            swap(nums, left, r);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    
}