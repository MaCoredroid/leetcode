class Solution {
    public int minimumSwap(String s1, String s2) {
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        int cnt1=0,cnt2=0;
        if(ch1.length!=ch2.length){
            return -1;
        }
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]==ch2[i]){
                continue;
            }
            if(ch1[i]=='x'){
                cnt1++;
            }else{
                cnt2++;
            }
        }
        if((cnt1+cnt2)%2!=0){
            return -1;
        }
        if(cnt1%2==0){
            return (cnt1+cnt2)/2;
        }
        return (cnt1+cnt2)/2+1;
    }
}