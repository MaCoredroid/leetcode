class Solution {
    public int countSegments(String s) {
        s=s.trim();
        int cnt=0;
        char[] ch=s.toCharArray();
        int index=0;
        while(index<ch.length){
            while(index<ch.length&&ch[index]!=' '){
                index++;
            }
            while(index<ch.length&&ch[index]==' '){
                index++;
            }
            cnt++;
        }
        return cnt;
    }
}