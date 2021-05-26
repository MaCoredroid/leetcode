class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int left=jobs[jobs.length-1];
        int right=0;
        for(int job:jobs){
            right+=job;
        }
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(check(mid,jobs,jobs.length-1,new int[k])){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean check(int limit,int[] jobs,int pointer, int[] work){
        if(pointer<0){
            return true;
        }
        int target=jobs[pointer];
        for(int i=0;i<work.length;i++){
            if(work[i]+target<=limit){
                work[i]+=target;
                if(check(limit,jobs,pointer-1,work)){
                    return true;
                }
                work[i]-=target;
            }
            if(work[i]==0||work[i]+target==limit){
                break;
            }
        }
        return false;
    }
}