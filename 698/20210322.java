class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%k!=0){
            return false;
        }
        if(sum<k){
            return false;
        }
        Arrays.sort(nums);
        int row=nums.length-1;
        int target=sum/k;
        while(nums[row]==target){
            row--;
            k--;
        }
        int[] groups=new int[k];
        Arrays.fill(groups,0);
        return backTrack(nums,row,target,groups);
    }

    private boolean backTrack(int[] nums,int row,int target,int[] groups){
        if(row<0){
            return true;
        }
        int temp=nums[row--];
        for(int i=0;i<groups.length;i++){
            if(groups[i]+temp<=target){
                groups[i]+=temp;
                if(backTrack(nums,row,target,groups)){
                    return true;
                }
                groups[i]-=temp;
            }
            if(groups[i]==0){
                return false;
            }
        }
        return false;
    }
}