class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freq=new HashMap<>();
        for(char task:tasks){
            freq.put(task,freq.getOrDefault(task,0)+1);
        }
        List<Integer> counts=new ArrayList<>();
        List<Integer> times=new ArrayList<>();
        for(Map.Entry<Character,Integer> entry:freq.entrySet()){
            counts.add(entry.getValue());
            times.add(1);
        }
        int time=0;
        for(int i=0;i<tasks.length;i++){
            time++;
            int minTime=Integer.MAX_VALUE;
            for(int j=0;j<freq.size();j++){
                if(counts.get(j)!=0){
                    minTime=Math.min(minTime,times.get(j));
                }
            }
            time=Math.max(time,minTime);
            int best=-1;
            for(int j=0;j<freq.size();j++){
                if(times.get(j)<=time&&counts.get(j)!=0){
                    if(best==-1||counts.get(j)>counts.get(best)){
                        best=j;
                    }
                }
            }
            counts.set(best,counts.get(best)-1);
            times.set(best,time+n+1);
        }
        return time;
    }
}