class Solution {
    public boolean isUnique(String astr) {
        long bits=0;
        for(int i=0;i<astr.length();i++){
            int move=astr.charAt(i)-'A';
            if((bits&(1L<<move))!=0){
                return false;
            }else{
                bits = bits | (1L<<move);
            }
        }
        return true;
    }
}