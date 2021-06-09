class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prev=-1;
        int cnt=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
            }else{
                cnt=i-prev;
                prev=i;
            }
            ans=Math.max(cnt,ans);
        }
        return ans;
    }
}