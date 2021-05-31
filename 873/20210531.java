class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        Map<Integer,Integer> index=new HashMap<>();
        Map<Integer,Integer> longest=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            index.put(arr[i],i);
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                int k=index.getOrDefault(arr[i]-arr[j],-1);
                if(k>=0&&k<j){
                    int cnt=longest.getOrDefault(k*n+j,2)+1;
                    longest.put(j*n+i,cnt);
                    ans=Math.max(ans,cnt);
                }
            }
        }
        return ans;
    }
}