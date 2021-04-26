class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int leftMin=nums[0];
        TreeMap<Integer,Integer> right=new TreeMap<>();
        for(int i=2;i<nums.length;i++){
            right.put(nums[i],right.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<nums.length-1;i++){
            if(leftMin<nums[i]){
                Integer temp=right.ceilingKey(leftMin+1);
                if(temp!=null&&temp<nums[i]){
                    return true;
                }
            }
            leftMin=Math.min(leftMin,nums[i]);
            right.put(nums[i+1],right.get(nums[i+1])-1);
            if(right.get(nums[i+1])<=0){
                right.remove(nums[i+1]);
            }
        }
        return false;
    }
}