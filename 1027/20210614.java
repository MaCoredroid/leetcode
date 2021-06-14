class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 1;
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
            for(int j=i-1;j>=0;j--){
                if(map.get(i).containsKey(nums[i]-nums[j])){
                    continue;
                }
                int cur =  map.get(j).getOrDefault(nums[i] - nums[j], 1);
                res=Math.max(cur+1,res);
                map.get(i).put(nums[i] - nums[j],cur+1);
            }
        }
        return res;
    }
}