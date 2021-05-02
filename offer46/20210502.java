class Solution {
    public int translateNum(int num) {
        return helper(Integer.toString(num),0);
    }

    private int helper(String s, int pointer){
        if(pointer==s.length()){
            return 1;
        }
        if(pointer+1<s.length()&&((s.charAt(pointer)=='2'&&s.charAt(pointer+1)<='5')||(s.charAt(pointer)=='1'))){
            return helper(s,pointer+1)+helper(s,pointer+2);
        }else{
            return helper(s,pointer+1);
        }
    }
}