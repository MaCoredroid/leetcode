class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans=new ArrayList<>();
        int l=lower,r=0;
        for(int i=0;i<=nums.length;i++){
            r=i==nums.length?upper:nums[i]-1;
            if(l==r){
                ans.add(""+l);
            }else if(l<r){
                ans.add(l+"->"+r);
            }
            l=i==nums.length?0:nums[i]+1;
        }
        return ans;
        
    }
}