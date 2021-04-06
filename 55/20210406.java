class Solution {
    public boolean canJump(int[] nums) {
        int boundary=0;
        for(int i=0;i<nums.length;i++){
            if(boundary<i){
                return false;
            }
            boundary=Math.max(boundary,i+nums[i]);
        }
        return true;
    }
}