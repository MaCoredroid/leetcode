class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(new ArrayList<>(),0,target,0,candidates);
        return ans;
    }
    
    public void helper(List<Integer> temp,int tempSum,int target,int index,int[] candidates){
        if(tempSum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(tempSum+candidates[i]>target){
                break;
            }
            temp.add(candidates[i]);
            helper(temp,tempSum+candidates[i],target,i,candidates);
            temp.remove(temp.size()-1);
        }
    }
}