class Solution {
    boolean rows[];
    boolean hills[];
    boolean dales[];
    int n;
    char[][] board;
    List<List<String>> output=new ArrayList();
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
        board[row][col]='Q';
        rows[col]=true;
        hills[row-col+2*n]=true;
        dales[row+col]=true;
    }
    public void removeQueen(int row,int col)
    {
        board[row][col]='.';
        rows[col]=false;
        hills[row-col+2*n]=false;
        dales[row+col]=false;
    }
    public void addSolution()
    {
        List<String> ans=new ArrayList();
        for(char[] res:board)
        {
            ans.add(String.valueOf(res));
        }
        output.add(ans);
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
                    addSolution();
                }
                else
                {
                    backTrack(row+1);
                }
                removeQueen(row,i);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        rows=new boolean[n];
        hills=new boolean[4*n];
        dales=new boolean[2*n];
        board=new char[n][n];
        for(char[] res:board)
        {
            Arrays.fill(res,'.');
        }
        backTrack(0);
        return output;

    }
}