class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        int[] next=new int[n];
        Arrays.fill(next,-1);
        for(int i=1;i<n;i++){
            int j=next[i-1];
            while(j!=-1&&s.charAt(j+1)!=s.charAt(i)){
                j=next[j];
            }
            if(s.charAt(j+1)==s.charAt(i)){
                next[i]=j+1;
            }
        }
        return next[n-1]!=-1&&n % (n - next[n - 1] - 1) == 0;
    }
}