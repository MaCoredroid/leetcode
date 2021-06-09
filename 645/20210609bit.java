class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans^=(i+1)^(nums[i]);
        }
        int rightmost=ans&(-ans);
        int a=0;
        for(int i=0;i<nums.length;i++){
            if(((i+1)&rightmost)!=0){
                a^=(i+1);
            }
            if((nums[i]&rightmost)!=0){
                a^=nums[i];
            }
        }
        for(int val:nums){
            if(val==a){
                return new int[]{a,a^ans};
            }
        }
        return new int[]{a^ans,a};
    }
}