class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    char temp=board[i][j];
                    board[i][j]=' ';
                    if(dfs(board,word,1,i,j)){
                        return true;
                    }
                    board[i][j]=temp;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int pos,int row, int col){
        if(pos==word.length()){
            return true;
        }
        if(row-1>=0&&board[row-1][col]==word.charAt(pos)){
            char temp=board[row-1][col];
            board[row-1][col]=' ';
            if(dfs(board,word,pos+1,row-1,col)){
                return true;
            }
            board[row-1][col]=temp;
        }
        if(row+1<board.length&&board[row+1][col]==word.charAt(pos)){
            char temp=board[row+1][col];
            board[row+1][col]=' ';
            if(dfs(board,word,pos+1,row+1,col)){
                return true;
            }
            board[row+1][col]=temp;
        }
        if(col-1>=0&&board[row][col-1]==word.charAt(pos)){
            char temp=board[row][col-1];
            board[row][col-1]=' ';
            if(dfs(board,word,pos+1,row,col-1)){
                return true;
            }
            board[row][col-1]=temp;
        }
        if(col+1<board[0].length&&board[row][col+1]==word.charAt(pos)){
            char temp=board[row][col+1];
            board[row][col+1]=' ';
            if(dfs(board,word,pos+1,row,col+1)){
                return true;
            }
            board[row][col+1]=temp;
        }
        return false;
    }
}