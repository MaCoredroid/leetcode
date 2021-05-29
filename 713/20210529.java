class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int ans=1;
        int left=0;
        int cnt=0;
        for(int right=0;right<nums.length;right++){
            ans*=nums[right];
            while(ans>=k){
                ans/=nums[left++];
            }
            cnt+=right-left+1;
        }
        return cnt;
    }
}