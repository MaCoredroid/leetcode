class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        int pre=0;
        for(int num:nums){
            pre+=num;
            if(map.containsKey(pre-k)){
                ans+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}