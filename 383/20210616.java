class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] res=new int[26];
        for(char c:magazine.toCharArray()){
            res[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            res[c-'a']--;
            if(res[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}