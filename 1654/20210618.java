class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(x%(gcd(a,b))!=0){
            return -1;
        }
        boolean[] vis=new boolean[6001];
        boolean[] ban=new boolean[2001];
        for(int pointer:forbidden){
            vis[pointer]=true;
            ban[pointer]=true;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o1[0]-o2[0]));
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(a>=b&&temp[1]>x){
                continue;
            }
            if(temp[1]==x){
                return temp[0];
            }
            if(!vis[temp[1]]){
                vis[temp[1]]=true;
                if(temp[1]+a<=6000&&!vis[temp[1]+a]){
                    pq.offer(new int[]{temp[0]+1,temp[1]+a});
                }
                if(temp[1]+a-b<=6000&&temp[1]+a-b>=0&&!vis[temp[1]+a-b]&&!(temp[1]+a<=2000&&ban[temp[1]+a])){
                    pq.offer(new int[]{temp[0]+2,temp[1]+a-b});
                }
            }
        }
        return -1;
    }

    private int gcd(int a,int b){
        if(a>b){
            return gcd(b,a);
        }
        while(a%b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return b;
    }
}