class Solution {
    public int slidingPuzzle(int[][] board) {
        int m=board.length,n=board[0].length;
        int zi=0,zj=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    zi=i;
                    zj=j;
                    break;
                }
            }
            if(board[zi][zj]==0){
                break;
            }
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> queue = new ArrayDeque();
        Node start = new Node(board, zi, zj, 0);
        queue.add(start);
        Set<String> seen=new HashSet<>();
        String target = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}});
        if(start.boardstring.equals(target)){
            return 0;
        }
        seen.add(start.boardstring);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            for(int i=0;i<4;i++){
                int nx=node.zero_r+directions[i][0];
                int ny=node.zero_c+directions[i][1];
                if(nx<0||nx>=m||ny<0||ny>=n){
                    continue;
                }
                int[][] newboard = new int[m][n];
                int t = 0;
                for (int[] row: node.board){
                    newboard[t++] = row.clone();
                }
                int temp=newboard[nx][ny];
                newboard[nx][ny]=newboard[node.zero_r][node.zero_c];
                newboard[node.zero_r][node.zero_c]=temp;
                Node toAdd=new Node(newboard,nx,ny,node.depth+1);
                if(seen.contains(toAdd.boardstring)){
                    continue;
                }
                if(toAdd.boardstring.equals(target)){
                    return toAdd.depth;
                }
                queue.add(toAdd);
                seen.add(toAdd.boardstring);
            }
        }
        return -1;


    }

    
}

class Node {
    int[][] board;
    String boardstring;
    int zero_r;
    int zero_c;
    int depth;
    Node(int[][] B, int r, int c, int d) {
        board = B;
        boardstring = Arrays.deepToString(board);
        zero_r = r;
        zero_c = c;
        depth = d;
    }
}
