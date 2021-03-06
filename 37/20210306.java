class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board,0,0);
    }
    public boolean backTrack(char[][] board, int i,int j){
        if(i==8&&j==9){
            return true;
        }
        if(j==9){
            i++;
            j=0;
        }
        if(board[i][j]=='.'){
            Set<Integer> ans= findPossibleAnswer(board,i,j);
            for(Integer ret:ans){
                board[i][j]=(char)(ret+'0');
                if(backTrack(board,i,j+1)){
                    return true;
                }
                board[i][j]='.';
            }
            return false;
        }else{
            return backTrack(board,i,j+1);
        }
    }

    private Set<Integer> findPossibleAnswer(char[][] board,int i,int j){
        Set<Integer> ret = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for(int p=0;p<9;p++){           
            ret.remove(board[i][p]-'0');
        }
        for(int p=0;p<9;p++){
            ret.remove(board[p][j]-'0');   
        }
        int left=i/3;
        int right=j/3;
        for(int p=left*3;p<left*3+3;p++){
            for(int q=right*3;q<right*3+3;q++){
                ret.remove(board[p][q]-'0');
            }
        }
        return ret;
    }
}