class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for(String word:words){
            if(search(board,word)){
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean search(char[][] board,String word){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j]=' ';
                    if(backTrack(word,1,board,i,j)){
                        board[i][j]=word.charAt(0);
                        return true;
                    }
                    board[i][j]=word.charAt(0);
                }
            }
        }
        return false;
    }

    private boolean backTrack(String word, int start,char[][] board, int row, int col){
        if(start>=word.length()){
            return true;
        }
        if(row-1>=0&&board[row-1][col]==word.charAt(start)){
            char temp=board[row-1][col];
            board[row-1][col]=' ';
            if(backTrack(word,start+1,board,row-1,col)){
                board[row-1][col]=temp;
                return true;
            }
            board[row-1][col]=temp;
        }
        if(row+1<board.length&&board[row+1][col]==word.charAt(start)){
            char temp=board[row+1][col];
            board[row+1][col]=' ';
            if(backTrack(word,start+1,board,row+1,col)){
                board[row+1][col]=temp;
                return true;
            }
            board[row+1][col]=temp;
        }
        if(col-1>=0&&board[row][col-1]==word.charAt(start)){
            char temp=board[row][col-1];
            board[row][col-1]=' ';
            if(backTrack(word,start+1,board,row,col-1)){
                board[row][col-1]=temp;
                return true;
            }
            board[row][col-1]=temp;
        }
        if(col+1<board[0].length&&board[row][col+1]==word.charAt(start)){
            char temp=board[row][col+1];
            board[row][col+1]=' ';
            if(backTrack(word,start+1,board,row,col+1)){
                board[row][col+1]=temp;
                return true;
            }
            board[row][col+1]=temp;
        }
        return false;
        
    }
}