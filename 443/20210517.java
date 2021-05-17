class Solution {
    public int compress(char[] chars) {
        int origin=0,write=0;
        for(int read=0;read<chars.length;read++){
            if(read+1==chars.length||chars[read]!=chars[read+1]){
                chars[write++]=chars[origin];
                if(read>origin){
                    for(char c:(""+(read-origin+1)).toCharArray()){
                        chars[write++]=c;
                    }
                }
                origin=read+1;
            }
        }
        return write;

    }
}