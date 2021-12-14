class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->(o1[0]-o2[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int[] interval:intervals){
            if(!pq.isEmpty()&&pq.peek()<=interval[0]){
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }
}