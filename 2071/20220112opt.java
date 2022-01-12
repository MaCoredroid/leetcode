class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n=tasks.length, m=workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int lo=0,hi=Math.min(m,n);
        while(lo<=hi){
            int mid=lo+((hi-lo)>>1);
            if(can_match(mid,tasks,workers,pills,strength)){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return lo-1;
    }
    
    public boolean can_match(int count, int[] tasks, int workers[], int pills, int strength){
        Deque<Integer> queue = new ArrayDeque<>();
        int index = workers.length -1;
        for(int i = count -1;i>=0;i--){
            while(index >= workers.length - count && workers[index]+strength >= tasks[i]){
                queue.addLast(workers[index]);
                index--;
            }

            if(queue.isEmpty()){
                return false;
            }

            if(queue.peekFirst() >= tasks[i]){
                queue.pollFirst();
            }else{
                queue.pollLast();
                pills--;
                if(pills < 0){
                    return false;
                }
            }

        }

        return true;
    
    }
}