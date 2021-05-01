class Solution {
    public int lengthOfLastWord(String s) {
        int right=s.length()-1;
        while(right>=0&&s.charAt(right)==' '){
            right--;
        }
        int count=0;
        while(right>=0&&s.charAt(right)!=' '){
            right--;
            count++;
        }
        return count;
    }
}