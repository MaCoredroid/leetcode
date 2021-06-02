class Solution {
    public int reverseBits(int num) {
        String numstr=Integer.toBinaryString(num);
        while(numstr.length()<32){
            numstr+="0";
        }
        char[] ch=numstr.toCharArray();
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
        return ans;

    }
}