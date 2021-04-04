class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        backTrack(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> res,int[] candidates, int target, int start){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        if(candidates[start]>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            res.add(candidates[i]);
            backTrack(ans,res,candidates,target-candidates[i],i);
            res.remove(res.size()-1);
        }
    }
    

    
}