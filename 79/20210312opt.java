class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int pos,int row, int col){
        if(pos>=word.length()){
            return true;
        }
        if(row>=0&&row<board.length&&col>=0&&col<board[0].length&&board[row][col]==word.charAt(pos)){
            char temp=board[row][col];
            board[row][col]=' ';
            if(dfs(board,word,pos+1,row+1,col)||dfs(board,word,pos+1,row-1,col)||dfs(board,word,pos+1,row,col-1)||dfs(board,word,pos+1,row,col+1)){
                return true;
            }
            board[row][col]=temp;
        }
        return false;
    }
}