class Solution {
    public String reverseVowels(String s) {
        char[] ch=s.toCharArray();
        int left=0;
        int right=ch.length-1;
        while(left<right){
            while(left<right&&!check(ch[left])){
                left++;
            }
            while(left<right&&!check(ch[right])){
                right--;
            }
            if(left>=right){
                break;
            }
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        return new String(ch);
    }

    private boolean check(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}