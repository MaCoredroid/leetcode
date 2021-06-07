class Solution {
    public boolean checkRecord(String s) {
        char[] ch=s.toCharArray();
        int cnt=0;
        int cnt1=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='A'){
                cnt++;
            }
            if(ch[i]=='L'){
                cnt1++;
                if(cnt1>2){
                    return false;
                }
            }else{
                cnt1=0;
            }
        }
        return cnt<=1;
    }
}