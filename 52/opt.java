class Solution {
    boolean rows[];
    boolean hills[];
    boolean dales[];
    int n;
    int ans;
    public boolean isUnderAttack(int row,int col)
    {
        boolean res=rows[col]||hills[row-col+2*n]||dales[row+col];
        if(res==true)
        {
            return true;
        }
        return false;
    }
    public void placeQueen(int row,int col)
    {
        
        rows[col]=true;
        hills[row-col+2*n]=true;
        dales[row+col]=true;
    }
    public void removeQueen(int row,int col)
    {
        
        rows[col]=false;
        hills[row-col+2*n]=false;
        dales[row+col]=false;
    }
    public void backTrack(int row)
    {
        for(int i=0;i<n;i++)
        {
            if(!isUnderAttack(row,i))
            {
                placeQueen(row,i);
                if(row==n-1)
                {
                    ans++;
                }
                else
                {
                    backTrack(row+1);
                }
                removeQueen(row,i);
            }
        }
    }
    public int totalNQueens(int n) {
        this.n=n;
        rows=new boolean[n];
        hills=new boolean[4*n];
        dales=new boolean[2*n];
        backTrack(0);
        return ans;
    }
}