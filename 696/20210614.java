class Solution {
    public int countBinarySubstrings(String s) {
        int pre=0;
        char[] ch=s.toCharArray();
        int n=ch.length;
        int p=0;
        int ret=0;
        while(p<n){
            int cnt=1;
            while(p+1<n&&ch[p]==ch[p+1]){
                cnt++;
                p++;
            }
            ret+=Math.min(cnt,pre);
            pre=cnt;
            p++;
        }
        return ret;
    }
}