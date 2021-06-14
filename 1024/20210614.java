class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(o1,o2)->(o1[0]-o2[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->(o2-o1));
        int now=0;
        int p=0;
        int ans=0;
        while(now<time){
            while(p<clips.length&&clips[p][0]<=now){
                pq.offer(clips[p][1]);
                p++;
            }
            if(pq.isEmpty()){
                return -1;
            }
            Integer res=pq.poll();
            now=res;
            ans++;
        }
        return ans;
    }
}