class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backTrack(ans,nums,0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans,int[] nums,int pos){
        if(pos==nums.length-1){
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                res.add(nums[i]);
            }
            ans.add(res);
            return;
        }
        for(int i=pos;i<nums.length;i++){
            swap(nums,pos,i);
            backTrack(ans,nums,pos+1);
            swap(nums,i,pos);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}