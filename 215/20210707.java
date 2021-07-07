class Solution {
    Random ran=new Random();
    public int findKthLargest(int[] nums, int k) {
        k=nums.length-k;
        return helper(nums,0,nums.length-1,k);
    }
    
    private int helper(int[] nums,int l,int r,int target){
        int index=l+ran.nextInt(r-l+1);
        int temp=nums[l];
        nums[l]=nums[index];
        nums[index]=temp;
        int left=l,right=r;
        if(left>=right){
            return nums[left];
        }
        int pivot=nums[left];
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
        if(left==target){
            return nums[left];
        }else if(left<target){
            return helper(nums,left+1,r,target);
        }else{
            return helper(nums,l,left-1,target);
        }
    }
}