class Solution {
    
    LinkedList<Integer> temp=new LinkedList();
    List<List<Integer>> ans=new ArrayList();
    int k=0;
    int n=0;
    public List<List<Integer>> combine(int n, int k) {
        
        this.k=k;
        this.n=n;
        backTrack(0);
        return ans;
    }

    public void backTrack(int start)
    {
        if(temp.size()==k)
        {
            ans.add(new LinkedList(temp));
            return;
        }
        for(int i=start+1;i<=n;i++)
        {            
            temp.add(i);
            backTrack(i);
            temp.removeLast();          
        }
    }
}