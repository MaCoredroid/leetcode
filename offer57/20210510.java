class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(nums[right]+nums[left]!=target&&left<right){
            if(nums[right]+nums[left]<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{nums[left],nums[right]};
    }
}