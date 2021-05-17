class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int diff=nums[1]-nums[0];
        int left=0;
        int ans=0;
        for(int right=1;right<nums.length;right++){
            if(right==nums.length-1||nums[right+1]-nums[right]!=diff){
                int len=right-left+1;
                int i=3;
                while(len>=i){
                    ans+=len-i+1;
                    i++;
                }
                left=right;
                if(right!=nums.length-1){
                    diff=nums[right+1]-nums[right];
                }
            }
        }
        return ans;
    }
}