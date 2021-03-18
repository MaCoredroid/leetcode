class Solution {
    public String reverseOnlyLetters(String S) {
        int left=0;
        int right=S.length()-1;
        char[] ch=S.toCharArray();
        while(left<right){
            if(!isCharacter(ch[left])){
                left++;
                continue;
            }
            if(!isCharacter(ch[right])){
                right--;
                continue;
            }
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        return new String(ch);
    }

    private boolean isCharacter(char c){
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }
}