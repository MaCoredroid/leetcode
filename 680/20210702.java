class Solution {
    public boolean validPalindrome(String s) {
        return helper(s.toCharArray(),0,s.length()-1,true);
    }
    
    private boolean helper(char[] ch,int left,int right,boolean flag){
        while(left<right){
            if(ch[left]==ch[right]){
                left++;
                right--;
            }else{
                if(!flag){
                    return false;
                }
                return helper(ch,left+1,right,false)||helper(ch,left,right-1,false);
            }
        }
        return true;
    }
}