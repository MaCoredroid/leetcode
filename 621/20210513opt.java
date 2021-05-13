class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts=new int[26];
        int maxExec=0;
        for(char task:tasks){
            counts[task-'A']++;
        }
        int maxCount=0;
        for(int i=0;i<26;i++){
            maxExec=Math.max(maxExec,counts[i]);
        }
        for(int i=0;i<26;i++){
            if(counts[i]==maxExec){
                maxCount++;
            }
        }
        return Math.max((maxExec-1)*(n+1)+maxCount,tasks.length);
        
    }
}