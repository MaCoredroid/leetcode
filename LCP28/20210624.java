class Solution {
    public int purchasePlans(int[] nums, int target) {
        int mod=1000000007;
        int left=0;
        int right=nums.length-1;
        int cnt=0;
        Arrays.sort(nums);
        while(left<right){
            if(nums[left]+nums[right]>target){
                right--;
            }else{
                cnt=cnt+right-left;
                left++;
            }
            cnt%=mod;
        }
        return cnt;
    }
}