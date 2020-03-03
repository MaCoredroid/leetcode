class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] map=new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(helper(board,word,i,j,0,map))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word,int i,int j, int length,boolean[][] map)
    {
        if(length==word.length())
        {
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||map[i][j])
        {
            return false;
        }
        boolean hasPath=false;
        if(board[i][j]==word.charAt(length))
        {
            map[i][j]=true;
            hasPath=helper(board,word,i+1,j,length+1,map)||helper(board,word,i-1,j,length+1,map)||helper(board,word,i,j+1,length+1,map)||helper(board,word,i,j-1,length+1,map);
        }
        map[i][j]=false;
        return hasPath;
    }
}