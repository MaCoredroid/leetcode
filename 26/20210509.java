class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer=0,fast=0;
        while(fast<nums.length){
            while(fast+1<nums.length&&nums[fast]==nums[fast+1]){
                fast++;
            }
            nums[pointer]=nums[fast];
            fast++;
            pointer++;
        }
        return pointer;
    }
}