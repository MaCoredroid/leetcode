class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans=1;
        int pointer1=0;
        int pointer2=1;
        while(pointer2<nums.length){
            while(pointer2<nums.length&&nums[pointer2]>nums[pointer2-1]){
                pointer2++;
            }
            ans=Math.max(ans,pointer2-pointer1);
            pointer1=pointer2;
            pointer2++;
        }
        return ans;

    }
}