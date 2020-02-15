class Solution {
    
    List<Integer> temp=new ArrayList();
    List<List<Integer>> ans=new ArrayList();
    public List<List<Integer>> combine(int n, int k) {       
        backTrack(1,n,k);
        return ans;
    }

    public void backTrack(int start,int n,int k)
    {
        
        if(temp.size()==k)
        {
            ans.add(new LinkedList(temp));
            return;
        }       
        for(int i=start;i<= n - (k -temp.size()) + 1;i++)
        {            
            temp.add(i);
            backTrack(i+1,n,k);
            temp.remove(temp.size()-1);          
        }
    }
}