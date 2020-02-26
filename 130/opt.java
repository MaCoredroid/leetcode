import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0)
        {
            return;
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                boolean isEdge= (i==0||j==0||i==board.length-1||j==board[0].length-1);
                if(isEdge&&board[i][j]=='O')
                {
                    dfs(board,i,j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j)
    {
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='X'||board[i][j]=='#')
        {
            return;
        }
        board[i][j]='#';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}