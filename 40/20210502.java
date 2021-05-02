class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans,new ArrayList<>(),candidates,target,0,0);
        return ans;

    }

    private void backTrack(List<List<Integer>> ans, List<Integer> curr, int [] candidates, int target, int sum,int pointer){
        if(target==sum){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=pointer;i<candidates.length;i++){
            if(candidates[pointer]>target-sum){
                break;
            }
            curr.add(candidates[i]);
            backTrack(ans,curr,candidates,target,sum+candidates[i],i+1);
            curr.remove(curr.size()-1);
            while(i+1<candidates.length&&candidates[i+1]==candidates[i]){
                i++;
            }
        }
    }
}