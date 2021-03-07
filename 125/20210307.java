class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j&&!valid(s.charAt(i))){
                i++;
            }
            while(i<j&&!valid(s.charAt(j))){
                j--;
            }
            if(toLowerCase(s.charAt(i))==toLowerCase(s.charAt(j))){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    private boolean valid(char c){
        return (c>='0'&&c<='9')||(c>='A'&&c<='Z')||(c>='a'&&c<='z');
    }

    private char toLowerCase(char c){
        if(c>='A'&&c<='Z'){
            return (char)(c+32);
        }else{
            return c;
        }
    }
}