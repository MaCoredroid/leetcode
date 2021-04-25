class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        backTrack(ans,n,k,new ArrayList<Integer>(),1);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, int n,int k,List<Integer> curr,int pointer){
        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=pointer;i<=n;i++){
            curr.add(i);
            backTrack(ans,n,k,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}