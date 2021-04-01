class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i+2<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            if(nums[i]+nums[i+1]+nums[i+2]>target){
                left=i+1;
                right=i+2;
            }else if(nums[i]+nums[nums.length-2]+nums[nums.length-1]<target){
                left=nums.length-2;
                right=nums.length-1;
            }
            while(left<right){
                int res=nums[left]+nums[right]+nums[i];
                if(res==target){
                    return target;
                }
                if(Math.abs(target-res)<Math.abs(target-ans)){
                    ans=res;
                }
                if(res>target){
                    right--;
                }else{
                    left++;
                }
            }
            while(i+1<nums.length&&nums[i+1]==nums[i]){
                i++;
            }
        }
        return ans;
    }
}