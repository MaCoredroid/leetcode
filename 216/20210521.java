class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(new ArrayList<>(),1,k,n);
        return ans;
    }

    public void backTrack(List<Integer> curr, int pointer,int k,int n){
        if(n==0&&k==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(k==0||n==0){
            return;
        }
        for(int i=pointer;i<=Math.min(n,9);i++){
            curr.add(i);
            backTrack(curr,i+1,k-1,n-i);
            curr.remove(curr.size()-1);
        }
    }
}