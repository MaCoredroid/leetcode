class Solution {
    public int minJump(int[] jump) {
        int w=0;
        int[] f=new int[jump.length];
        int[] maxLen=new int[jump.length];
        int ans=jump.length;
        Arrays.fill(f,jump.length);
        f[0]=0;
        for(int i=0;i<jump.length;i++){
            if(maxLen[w]<i){
                w++;
            }
            int next=i+jump[i];
            f[i]=Math.min(f[i],w+1);
            if(next>=jump.length){
                ans=Math.min(ans,f[i]+1);
            }else if(f[next]>f[i]+1){
                f[next]=f[i]+1;
                maxLen[f[next]]=Math.max(maxLen[f[next]],next);
            }
        }
        return ans;
    }
}