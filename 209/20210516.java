class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int sum=nums[0];
        int ans=nums.length+1;
        if(nums[0]>=target){
            return 1;
        }
        while(right<nums.length-1){
            right++;
            sum+=nums[right];
            while(left<=right&&sum>=target){
                ans=Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return ans==nums.length+1?0:ans;
    }
}