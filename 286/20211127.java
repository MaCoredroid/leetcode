class Solution {
    int[][] dirs={{1,0},{0,1},{0,-1},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int step=1;
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] res=q.poll();
                for(int d=0;d<4;d++){
                    int newX=res[0]+dirs[d][0];
                    int newY=res[1]+dirs[d][1];
                    if(newX>=0&&newX<rooms.length&&newY>=0&&newY<rooms[0].length&&rooms[newX][newY]==2147483647){
                        rooms[newX][newY]=step;
                        q.offer(new int[]{newX,newY});
                    }
                }
            }
            step++;
        }
    }
}