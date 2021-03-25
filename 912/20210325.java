class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length<=0){
            return nums;
        }
        partition(nums,0,nums.length-1);
        return nums;
    }

    private void partition(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int pivot=nums[left];
        int originLeft=left;
        int originRight=right;
        while(left<right){
            while(left<right&&nums[right]>=pivot){
                right--;
            }
            nums[left]=nums[right];
            while(left<right&&nums[left]<=pivot){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=pivot;
        partition(nums,originLeft,left-1);
        partition(nums,left+1,originRight);

    }

    
}