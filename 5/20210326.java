class Solution {
    public String longestPalindrome(String s) {
        char[] ch=s.toCharArray();
        String ans="";
        int pointer=0;
        while(pointer<ch.length){
            int left=pointer-1;
            int right=pointer+1;
            int count=1;
            while(left>=0&&right<ch.length&&ch[left]==ch[right]){
                count+=2;
                left--;
                right++;
            }
            if(count>ans.length()){
                ans=s.substring(left+1,right);
            }
            count=0;
            left=pointer;
            right=pointer+1;
            while(left>=0&&right<ch.length&&ch[left]==ch[right]){
                count+=2;
                left--;
                right++;
            }
            if(count>ans.length()){
                ans=s.substring(left+1,right);
            }
            pointer++;
        }
        return ans;
    }
}