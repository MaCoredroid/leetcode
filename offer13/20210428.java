class Solution {
    public int movingCount(int m, int n, int k) {
        if(k==0){
            return 1;
        }
        boolean[][] vis=new boolean[m][n];
        vis[0][0]=true;
        int ans=1;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int[] right={cell[0],cell[1]+1};
            int[] down={cell[0]+1,cell[1]};
            if(right[1]<n&&!vis[right[0]][right[1]]&&(getCount(right[0])+getCount(right[1])<=k)){
                ans++;
                vis[right[0]][right[1]]=true;
                queue.offer(right);
            }
            if(down[0]<m&&!vis[down[0]][down[1]]&&(getCount(down[0])+getCount(down[1])<=k)){
                ans++;
                vis[down[0]][down[1]]=true;
                queue.offer(down);
            }
        }
        return ans;

    }

    private int getCount(int x){
        int ret=0;
        while(x>0){
            ret+=x%10;
            x/=10;
        }
        return ret;   
    }
}