class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int pivot=nums[left];
        while(left<right){
            while(left<right&&nums[right]%2!=0){
                right--;
            }
            nums[left]=nums[right];
            while(left<right&&nums[left]%2==0){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=pivot;
        return nums;
    }
}