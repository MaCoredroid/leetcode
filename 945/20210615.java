class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int taken=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                taken++;
                ans-=nums[i];
            }else{
                int give=Math.min(taken,nums[i]-nums[i-1]-1);
                ans += give * (give + 1) / 2 + give * nums[i - 1];
                taken-=give;
            }
        }
        if(nums.length>0){
            ans += taken * (taken + 1) / 2 + taken * nums[nums.length - 1];
        }
        return ans;
    }
}