class Solution {
    public int[] runningSum(int[] nums) {
        int[] ret=new int[nums.length];
        int prev=0;
        for(int i=0;i<nums.length;i++){
            prev+=nums[i];
            ret[i]=prev;
        }
        return ret;
    }
}