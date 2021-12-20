class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int l=i+1,r=nums.length-1;
            while(l<r){
                int temp=nums[i]+nums[l]+nums[r];
                if(temp>target){
                    if(Math.abs(ans-target)>Math.abs(temp-target)){
                        ans=temp;
                    }
                    r--;
                }else if(temp<target){
                    if(Math.abs(ans-target)>Math.abs(temp-target)){
                        ans=temp;
                    }
                    l++;
                }else{
                    return target;
                }
            }
        }
        return ans;
    }
}