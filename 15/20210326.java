class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]+nums[i+1]+nums[i+2]>0){
                break;
            }
            if(nums[i]+nums[nums.length-2]+nums[nums.length-1]<0){
                continue;
            }
            for(int j=i+1;j<nums.length-1;j++){
                if(nums[i]+nums[j]+nums[j+1]>0){
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-1]<0){
                    continue;
                }
                for(int p=j+1;p<nums.length;p++){
                    if(nums[i]+nums[j]+nums[p]==0){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[p]));
                        break;
                    }
                }
                while(j<nums.length-2&&nums[j+1]==nums[j]){
                    j++;
                }
            }
            while(i+1<nums.length&&nums[i+1]==nums[i]){
                i++;
            }
        }
        return ans;
    }
}