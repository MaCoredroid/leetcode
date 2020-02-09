class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,Integer>[] rows=new  HashMap[9];
        HashMap<Character,Integer>[] cols=new  HashMap[9];
        HashMap<Character,Integer>[] boxes=new  HashMap[9];
        for(int i=0;i<9;i++)
        {
            rows[i]=new HashMap<Character,Integer>();
            cols[i]=new HashMap<Character,Integer>();
            boxes[i]=new HashMap<Character,Integer>();
        }
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    continue;
                }
                int boxIndex=(i/3)*3+j/3;
                rows[i].put(board[i][j],rows[i].getOrDefault(board[i][j],0)+1);
                cols[j].put(board[i][j],cols[j].getOrDefault(board[i][j],0)+1);
                boxes[boxIndex].put(board[i][j],boxes[boxIndex].getOrDefault(board[i][j],0)+1);
                if(rows[i].get(board[i][j])>1||cols[j].get(board[i][j])>1||boxes[boxIndex].get(board[i][j])>1)
                {
                    return false;
                }
            }
        }
        return true;
    }
}