class Solution {
    public String breakPalindrome(String palindrome) {
        char[] ch=palindrome.toCharArray();
        if(ch.length==1){
            return "";
        }
        int p=0;
        while(p<ch.length&&(p==ch.length/2||ch[p]=='a')){
            p++;
        }
        if(p==ch.length){
            ch[p-1]='b';
        }else{
            ch[p]='a';
        }
        return new String(ch);
    }
}