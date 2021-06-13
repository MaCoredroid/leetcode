class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n=apples.length;
        int time=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o1[0]-o2[0]));
        int sum=0;
        int ans=0;
        while(sum>0||time<n){
            if(time<n&&apples[time]>0){
                pq.offer(new int[]{time+days[time],apples[time]});
                sum+=apples[time];
            }
            while(!pq.isEmpty()){
                int[] temp=pq.poll();
                if(temp[0]<=time){
                    sum-=temp[1];
                }else{
                    ans++;
                    temp[1]--;
                    if(temp[1]>0){
                        pq.offer(temp);
                    }
                    sum--;
                    break;
                }
            }
            time++;       
        }
        return ans;
    }
}