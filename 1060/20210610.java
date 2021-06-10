class Solution {
    public int missingElement(int[] nums, int k) {
        for(int i=1;i<nums.length;i++){
            int ans=nums[i]-nums[i-1]-1;
            if(k>ans){
                k-=ans;
            }else{
                return nums[i-1]+k;
            }
        }
        return nums[nums.length-1]+k;
    }
}