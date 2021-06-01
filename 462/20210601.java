class Solution {
    private static Random random = new Random();
    public int minMoves2(int[] nums) {
        int sum=0;
        int k=nums.length/2;
        int median=helper(nums,0,nums.length-1,k);
        for(int num:nums){
            sum+=Math.abs(median-num);
        }
        return sum;
    }

    private int helper(int[] nums,int left,int right,int k){
        if(left==right){
            return nums[left];
        }
        randomNum(nums,left,right);
        int pivot=nums[left];
        int l=left;
        int r=right;
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
        if(l==k){
            return pivot;
        }else if(l<k){
            return helper(nums,l+1,right,k);
        }else{
            return helper(nums,left,l-1,k);
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