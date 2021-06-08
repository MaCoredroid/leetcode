class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt=new int[101];
        for(int num:nums){
            cnt[num]++;
        }
        for(int i=1;i<101;i++){
            cnt[i]+=cnt[i-1];
        }
        int[] ret=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ret[i]=nums[i]==0?0:cnt[nums[i]-1];
        }
        return ret;
    }
}