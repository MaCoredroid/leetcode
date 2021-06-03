class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int pre=0;
        int ret=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(pre)){
                map.put(pre,i);
            }
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                ret=Math.max(i-map.get(pre-k)+1,ret);
            }
        }
        return ret;
    }
}