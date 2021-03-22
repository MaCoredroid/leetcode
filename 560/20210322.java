class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int pre=0;
        HashMap<Integer,Integer> res=new HashMap<>();
        res.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            count+=res.getOrDefault(pre-k,0);
            res.put(pre,res.getOrDefault(pre,0)+1);
        }
        return count;
    }
}