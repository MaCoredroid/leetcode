class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0;
        for(;r<nums.length;r++){
            if(nums[r]==0){
                k--;
            }
            if(k<0){
                k+=1-nums[l];
                l++;
            }
        }
        return r-l;
    }
}