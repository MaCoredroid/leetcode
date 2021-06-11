class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] pre=new int[n+1];
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            pre[i+1]=(pre[i]+nums[i])%k;
            if(set.contains(pre[i+1])){
                return true;
            }
            set.add(pre[i]);
        }
        return false;
    }
}