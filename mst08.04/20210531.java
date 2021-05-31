class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
            backTrack(nums,new ArrayList<>(),0,i);
        }
        return ans;
    }

    public void backTrack(int[] nums,List<Integer> res,int pointer,int limit){
        if(limit==res.size()){
            ans.add(new ArrayList<>(res));
            return;
        }
        if(pointer>=nums.length){
            return;
        }
        if(res.size()+nums.length-pointer<limit){
            return;
        }
        for(int i=pointer;i<nums.length;i++){
            res.add(nums[i]);
            backTrack(nums,res,i+1,limit);
            res.remove(res.size()-1);
            while(pointer+1<nums.length&&nums[pointer]==nums[pointer+1]){
                pointer++;
            }
        }
    }
}