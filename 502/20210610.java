class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int ans=w;
        int n=profits.length;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,capital[i]);
        }
        if(w>=max){
            Arrays.sort(profits);
            int p=n-1;
            for(int i=0;i<Math.min(k,n);i++){
                ans+=profits[p--];
            }
            return ans;
        }
        for(int i=0;i<Math.min(k,n);i++){
            int temp=-1;
            for(int j=0;j<n;j++){
                if(capital[j]<=ans&&(temp==-1||profits[temp]<profits[j])){
                    temp=j;
                }
            }
            if(temp==-1){
                break;
            }
            ans+=profits[temp];
            capital[temp]=Integer.MAX_VALUE;
        }
        return ans;
    }
}