class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
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
        }
        return ans;
    }
}