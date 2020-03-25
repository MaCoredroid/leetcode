class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                int[] ret=new int[2];
                ret[0]=map.get(target-nums[i]);
                ret[1]=i;
                return ret;
            }
            else
            {
                map.put(nums[i],i);
            }
        }
        return new int[]{0,0};
    }
}