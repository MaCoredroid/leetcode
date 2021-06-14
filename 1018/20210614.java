class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ret=new ArrayList<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=ans*2+nums[i];
            ans=ans%5;
            ret.add(ans%5==0?true:false);
        }
        return ret;
    }
}