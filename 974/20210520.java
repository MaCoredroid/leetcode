class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,ans=0;
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            int module=(sum%k+k)%k;
            int temp=map.getOrDefault(module,0);
            ans+=temp;
            map.put(module,temp+1);
        }
        return ans;
    }
}