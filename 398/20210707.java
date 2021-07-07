class Solution {
    HashMap<Integer,List<Integer>> map;
    Random ran;
    public Solution(int[] nums) {
        ran=new Random();
        map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> ans=map.get(target);
        int index=ran.nextInt(ans.size());
        return ans.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */