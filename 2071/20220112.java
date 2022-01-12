class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n=tasks.length, m=workers.length;
        Arrays.sort(tasks);
        int lo=0,hi=Math.min(m,n)-1;
        int ans=-1;
        while(lo<=hi){
            int pilesReq=0;
            boolean possible=true;
            int mid=lo+((hi-lo)>>1);
            TreeMap<Integer,Integer> freqMap=new TreeMap<>();
            for(int w:workers){
                freqMap.put(w,freqMap.getOrDefault(w,0)+1);
            }
            for(int i=mid;i>=0;i--){
                if(tasks[i]<=freqMap.lastKey()){
                    int key=freqMap.lastKey();
                    freqMap.put(key,freqMap.get(key)-1);
                    if(freqMap.get(key)==0) freqMap.remove(key);
                }else{
                    Integer atleast=freqMap.ceilingKey(tasks[i]-strength);
                    if(atleast!=null){
                        pilesReq++;
                        freqMap.put(atleast,freqMap.get(atleast)-1);
                        if(freqMap.get(atleast)==0) freqMap.remove(atleast);
                    }else{
                        possible=false;
                        break;
                    }
                    
                }
                if(pilesReq>pills){
                    possible=false;
                    break;
                }
            }
            if(possible){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }
}