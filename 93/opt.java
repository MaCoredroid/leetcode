class Solution {
    int n=0;
    String s="";
    LinkedList<String> segements=new LinkedList<>();
    ArrayList<String> ans=new ArrayList<>();
    public boolean valid(String segement)
    {
        int m=segement.length();
        if(m>3)
        {
            return false;
        }
        return (segement.charAt(0)!='0')?(Integer.valueOf(segement)<=255):(m==1);
    }
    public List<String> restoreIpAddresses(String s) 
    {
        n=s.length();
        this.s=s;
        backTrack(-1,3);   
        return ans;    
    }
    public void updateOutput(int pos)
    {
        String segement=s.substring(pos+1,n);
        if(valid(segement))
        {
            segements.add(segement);
            ans.add(String.join(".", segements));
            segements.removeLast();
        }
    }
    public void backTrack(int prev_pos,int dots)
    {
        int max_pos=Math.min(n-1,prev_pos+4);
        for(int i=prev_pos+1;i<max_pos;i++)
        {
            String segement=s.substring(prev_pos+1,i+1);
            if(valid(segement))
            {
                segements.add(segement);
                if(dots-1==0)
                {
                    updateOutput(i);
                }
                else
                {
                    backTrack(i,dots-1);
                }
                segements.removeLast();
            }
        }
    }
}