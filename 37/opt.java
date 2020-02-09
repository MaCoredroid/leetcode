class Solution {
    boolean[][] rows=new boolean[9][9];
    boolean[][] cols=new boolean[9][9];
    boolean[][] boxes=new boolean[9][9];
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board=board;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    int num=board[i][j]-'1';
                    int boxIndex=(i/3)*3+j/3;
                    rows[i][num]=true;
                    cols[j][num]=true;
                    boxes[boxIndex][num]=true;
                }
            }
        }
        backTrack(0,0);
    }
    private boolean backTrack(int row,int col)
    {
        if(col == board[0].length)
        {
            col = 0;
            row++;
            if(row == board.length)
            {
                return true;
            }
        }
        if(board[row][col] == '.') 
        {
            for(int num = 0; num < 9; num++)
            {
                if(rows[row][num]||cols[col][num]||boxes[(row/3)*3+col/3][num])
                {
                    continue;
                }
                rows[row][num]=true;
                cols[col][num]=true;
                boxes[(row/3)*3+col/3][num]=true;
                board[row][col]=(char)('1'+num);
                if(backTrack(row,col+1))
                {
                    return true;
                }
                board[row][col]='.';
                rows[row][num]=false;
                cols[col][num]=false;
                boxes[(row/3)*3+col/3][num]=false;

            }
        }
        else
        {
            return backTrack(row,col+1);
        }
        return false;

    }
}