class Solution {
    public int balancedStringSplit(String s) {
        char[] ch=s.toCharArray();
        int ans=0;
        int cnt=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='R'){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt==0){
                ans++;
            }
        }
        return ans;
    }
}