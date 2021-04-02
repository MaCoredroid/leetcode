class Solution {
    public int strStr(String haystack, String needle) {
        char[] origin=haystack.toCharArray();
        char[] find=needle.toCharArray();
        for(int i=0;i<origin.length-find.length+1;i++){
            if(verify(origin,find,i)){
                return i;
            }
        }
        return -1;
    }

    private boolean verify(char[] origin, char[] needle, int pos ){
        int pointer=0;
        while(pointer<needle.length){
            if(pos<origin.length&&origin[pos]!=needle[pointer]){
                return false;
            }
            pos++;
            pointer++;
        }
        return pointer==needle.length;
    }
}