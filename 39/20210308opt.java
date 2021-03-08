class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ret= new ArrayList<>();
        backTrack(ans,ret,candidates,0,target);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans,List<Integer> ret, int[] candidates, int start, int target){
        if(target==0){
            ans.add(new ArrayList<>(ret));
            return;
        }
        if(start>=candidates.length){
            return;
        }
        if(target>=candidates[start]){
            ret.add(candidates[start]);
            backTrack(ans,ret,candidates,start,target-candidates[start]);
            ret.remove(ret.size()-1);
            backTrack(ans,ret,candidates,start+1,target);
        }else{
            return;
        }
    }

    
}