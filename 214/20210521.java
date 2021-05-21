class Solution {
    public String shortestPalindrome(String s) {
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
        int best=-1;
        for(int i=n-1;i>=0;i--){
            while(best!=-1&&s.charAt(best+1)!=s.charAt(i)){
                best=next[best];
            }
            if(s.charAt(best+1)==s.charAt(i)){
                best++;
            }
        }
        String add=(best==n-1?"":s.substring(best+1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }
}