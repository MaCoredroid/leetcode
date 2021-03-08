class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backTrack(candidates,0,target);
    }

    private List<List<Integer>> backTrack(int[] candidates,int start, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]<target){
                List<List<Integer>> ret=backTrack(candidates,i,target-candidates[i]);
                for(List<Integer> res:ret){
                    List<Integer> a=new ArrayList<>();
                    a.add(candidates[i]);
                    a.addAll(res);
                    ans.add(a);
                }
            }else if(candidates[i]==target){
                    List<Integer> a=new ArrayList<>();
                    a.add(candidates[i]);
                    ans.add(a);
                    return ans;
            }else{
                break;
            }
        }
        return ans;
    }
}