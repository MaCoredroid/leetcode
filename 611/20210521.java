class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            int k=i+2;
            for(int j=i+1;j<nums.length-1&& nums[i] != 0;j++){
                int temp=nums[i]+nums[j];
                while(k<nums.length&&nums[k]<temp){
                    k++;
                }
                ans+=k-j-1;
            }
        }
        return ans;
    }

    
}