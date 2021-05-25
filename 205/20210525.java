class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] record=new int[128];
        int[] record1=new int[128];
        Arrays.fill(record,-1);
        Arrays.fill(record1,-1);
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(record[s.charAt(i)]!=-1&&record[s.charAt(i)]!=t.charAt(i)){
                return false;
            }
            if(record1[t.charAt(i)]!=-1&&record1[t.charAt(i)]!=s.charAt(i)){
                return false;
            }
            record[s.charAt(i)]=t.charAt(i);
            record1[t.charAt(i)]=s.charAt(i);
        }
        return true;
    }
}