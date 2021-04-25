class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i+1){
                continue;
            }
            int j=nums[i];
            nums[i]=-1;
            while(j!=-1&&nums[j-1]!=j){
                int temp=nums[j-1];
                nums[j-1]=j;
                j=temp;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==-1){
                ans.add(i+1);
            }
        }
        return ans;
    }
}