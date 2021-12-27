class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=Integer.MIN_VALUE;
        int l=0,r=nums.length-1;
        while(l<r){
            ans=Math.max(ans,nums[l]+nums[r]);
            l++;
            r--;
        }
        return ans;
    }
}