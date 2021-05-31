class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=1;i<=n;i++){
            ans^=i;
            ans^=nums[i-1];
        }
        return ans;
    }
}