class Solution {
    public int maxProduct(int[] nums) {
        int maxNum=nums[0];
        int minNum=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int mm=maxNum;
            int mn=minNum;
            minNum=Math.min(nums[i]*mm,Math.min(nums[i],nums[i]*mn));
            maxNum=Math.max(nums[i]*mm,Math.max(nums[i],nums[i]*mn));
            ans=Math.max(ans,maxNum);
        }
        return ans;
    }
}