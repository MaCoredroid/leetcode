class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> findDuplicates(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                helper(nums,i);
            }
        }
        return ans;
    }

    private void helper(int[] nums,int pos){
        int value=nums[pos];
        nums[pos]=-1;
        while(value!=-1&&nums[value-1]!=value){
            int temp=nums[value-1];
            nums[value-1]=value;
            value=temp;
        }
        if(value!=-1){
            ans.add(value);
        }
    }
}