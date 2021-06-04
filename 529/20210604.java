class Solution {
    int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(click);
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            int x=temp[0];
            int y=temp[1];
            if(board[x][y]=='M'){
                board[x][y]='X';
                break;
            }
            if(board[x][y]=='E'||board[x][y]=='C'){
                int num=0;
                for(int i=0;i<8;i++){
                    int nx=x+dirs[i][0];
                    int ny=y+dirs[i][1];
                    if(nx<0||nx>=m||ny<0||ny>=n){
                        continue;
                    }
                    if(board[nx][ny]=='M'){
                        num++;
                    }
                }
                if(num!=0){
                    board[x][y]=(char)('0'+num);
                }else{
                    for(int i=0;i<8;i++){
                        int nx=x+dirs[i][0];
                        int ny=y+dirs[i][1];
                        if(nx<0||nx>=m||ny<0||ny>=n){
                            continue;
                        }
                        if(board[nx][ny]=='E'){
                            queue.offer(new int[]{nx,ny});
                            board[nx][ny]='C';
                        }
                    }
                    board[x][y]='B';
                }
                
            }
        }
        return board;
    }
}