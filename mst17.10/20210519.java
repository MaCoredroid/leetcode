class Solution {
    public int majorityElement(int[] nums) {
        int pre=nums[0];
        int cnt=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==pre){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt==0){
                pre=nums[i];
                cnt=1;
            }
        }
        cnt=0;
        for(int num:nums){
            if(num==pre){
                cnt++;
            }
        }
        return cnt>nums.length/2?pre:-1;
    }

    
}