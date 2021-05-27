class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
        
    }

    private int helper(int[] nums,int k){
        int[] cnt=new int[nums.length+5];
        int temp=0;
        int left=0;
        int ans=0;
        for(int right=0;right<nums.length;right++){
            if(cnt[nums[right]]==0){
                temp++;
            }
            cnt[nums[right]]++;
            while(temp>k){
                cnt[nums[left]]--;
                if(cnt[nums[left]]==0){
                    temp--;
                }
                left++;
            }
            ans+=right-left;
        }
        return ans;
    }
}