class Solution {
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int value=nums[0];
        for(int i=1;i<nums.length;i++){
            if(value<0){
                value=0;
            }
            value+=nums[i];
            ans=Math.max(ans,value);
        }
        return ans;
    }
}