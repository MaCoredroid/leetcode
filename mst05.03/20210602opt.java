class Solution {
    public int reverseBits(int num) {
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            sb.append((num&1));
            num>>>=1;
        }
        sb.append('0');
        char[] ch=sb.toString().toCharArray();
        int left=0;
        int cnt=0;
        int ans=0;
        for(int right=0;right<ch.length;right++){
            if(ch[right]=='0'){
                cnt++;
            }
            while(left<right&&cnt>1){
                if(ch[left]=='0'){
                    cnt--;
                }
                left++;
            }
            ans=Math.max(right-left+1,ans);
        }
        if(ans>=32){
            ans=32;
        }
        return ans;

    }
}