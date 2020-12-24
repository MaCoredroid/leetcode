class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean[][] res=new boolean[m+1][n+1];
        res[0][0]=true;
        for(int i=0;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(p.charAt(j-1)!='*')
                {
                    if(match(s,p,i,j))
                    {
                        res[i][j]=res[i-1][j-1];
                    }
                }
                else
                {
                    res[i][j]=res[i][j-2];
                    if(match(s,p,i,j-1))
                    {
                        res[i][j]=res[i][j]||res[i-1][j];
                    }
                }
            }
        }
        return res[m][n];
    }
    private boolean match(String s ,String p ,int i,int j)
    {
        if(i==0)
        {
            return false;
        }
        if(p.charAt(j-1)=='.')
        {
            return true;
        }
        if(s.charAt(i-1)==p.charAt(j-1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}