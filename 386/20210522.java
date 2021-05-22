class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i,ans,n);
        }
        return ans;
    }

    private void dfs(int i,List<Integer> ans, int n){
        if(i>n){
            return;
        }
        ans.add(i);
        i*=10;
        for(int j=0;j<10;j++){
            dfs(i+j,ans,n);
        }
    }
}