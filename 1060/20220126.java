class Solution {
    public int missingElement(int[] nums, int k) {
        for(int i=0;i<nums.length-1;i++){
            int val=nums[i+1]-nums[i]-1;
            if(k>val) k-=val;
            else return nums[i]+k;
        }
        return nums[nums.length-1]+k;
    }
}