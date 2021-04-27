class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)){
                continue;
            }
            int temp=1;
            int curr=nums[i];
            while(set.contains(curr+1)){
                curr++;
                temp++;
            }
            ans=Math.max(ans,temp);
        }
        return ans;

    }
}