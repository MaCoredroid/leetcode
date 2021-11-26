class Solution {
    public boolean isMonotonic(int[] nums) {
        int p=1;
        while(p<nums.length&&nums[p]-nums[p-1]==0){
            p++;
        }
        if(p==nums.length) return true;
        boolean flag=nums[p]-nums[p-1]>0;
        p++;
        while(p<nums.length){
            if(nums[p]-nums[p-1]==0){
                p++;
                continue;
            }
            if(flag!=(nums[p]-nums[p-1]>0)) return false;
            p++;
        }
        return true;
    }
}