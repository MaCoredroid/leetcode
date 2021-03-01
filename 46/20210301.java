class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ans.add(nums[i]);
        }
        backTrack(res,ans,0);
        return res;
    }

    private void backTrack(List<List<Integer>> res,List<Integer> ans, int start){
        if(start==ans.size()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=start;i<ans.size();i++){
            Collections.swap(ans,start,i);
            backTrack(res,ans,start+1);
            Collections.swap(ans,i,start);
        }
    }
}