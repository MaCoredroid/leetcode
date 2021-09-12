class Solution {
    public String breakPalindrome(String palindrome) {
        char[] ch=palindrome.toCharArray();
        if(ch.length==0||ch.length==1){
            return "";
        }
        int left=0;
        int right=ch.length-1;
        while(left<right){
            if(ch[left]=='a'){
                left++;
                right--;
            }else{
                ch[left]='a';
                return new String(ch);
            }
        }
        ch[ch.length-1]='b';
        return new String(ch);
        
    }
}