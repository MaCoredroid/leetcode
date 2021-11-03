class Solution {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                searchAndSwap(nums,i);
                sort(nums,i+1,nums.length-1);
                return;
            }
        }
        sort(nums,0,nums.length-1);
    }
    
    public void searchAndSwap(int[] nums,int i){
        int target=nums[i];
        for(int j=nums.length-1;j>i;j--){
            if(nums[j]>target){
                nums[i]=nums[j];
                nums[j]=target;
                return;
            }
        }
    }
    
    public void sort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int l=left,r=right;
        int pivot=nums[l];
        while(l<r){
            while(l<r&&nums[r]>=pivot){
                r--;
            }
            nums[l]=nums[r];
            while(l<r&&nums[l]<=pivot){
                l++;
            }
            nums[r]=nums[l];
        }
        nums[l]=pivot;
        sort(nums,left,l-1);
        sort(nums,l+1,right);
    }
}