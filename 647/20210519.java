class Solution {
    public int countSubstrings(String s) {
        StringBuilder sb=new StringBuilder("$#");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append('#');
        }
        int n=sb.length();
        sb.append('!');
        int[] f=new int[n];
        int imax=0,rmax=0,ans=0;
        for(int i=1;i<n;i++){
            f[i]=i<=rmax?Math.min(rmax-i+1,f[2*imax-i]):1;
            while(sb.charAt(i-f[i])==sb.charAt(i+f[i])){
                f[i]++;
            }
            if(i+f[i]-1>rmax){
                imax=i;
                rmax=i+f[i]-1;
            }
            ans+=f[i]/2;
        }
        return ans;
        
    }
}