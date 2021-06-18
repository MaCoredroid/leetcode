class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prefix=0,max=0,min=0;
        for(int num:nums){
            prefix+=num;
            max=Math.max(max,prefix);
            min=Math.min(min,prefix);
            
        }
        return max-min;
    }
}