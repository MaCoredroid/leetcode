class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        Integer[] index=new Integer[n];
        for(int i=0;i<n;i++){
            index[i]=i;
        }
        Arrays.sort(index,(o1,o2)->(tasks[o1][0]-tasks[o2][0]));
        PriorityQueue<int[]> pq=new PriorityQueue<>((t1,t2)->{
            if(t1[0]==t2[0]){
                return t1[1]-t2[1];
            }else{
                return t1[0]-t2[0];
            }
        });
        int[] ret=new int[n];
        long now = 0;//当前时间，使用long防止int溢出
        int i = 0;//taskList的坐标
        int p = 0;//ret的坐标
        while(i<n){
            while(i<n&&tasks[index[i]][0]<=now){
                pq.offer(new int[]{tasks[index[i]][1],index[i]});
                i++;
            }
            if(pq.isEmpty()){
                now = (long)tasks[index[i]][0];
                while(i<n&&tasks[index[i]][0]<=now){
                    pq.offer(new int[]{tasks[index[i]][1],index[i]});
                    i++;
                }
            }
            int[] temp=pq.poll();
            ret[p++]=temp[1];
            now+=temp[0];
        }
        while(!pq.isEmpty()){
            ret[p++]=pq.poll()[1];
        }
        return ret;
    }
}