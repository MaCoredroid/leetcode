class Solution {
    public int longestSubstring(String s, int k) {
        return dfs(s,0,s.length()-1,k);
    }

    private int dfs(String s,int left,int right,int k){
        int[] count=new int[26];
        for(int i=left;i<=right;i++){
            count[s.charAt(i)-'a']++;
        }
        char split=' ';
        for(int i=0;i<count.length;i++){
            if(count[i]<k&&count[i]>0){
                split=(char)(i+'a');
                break;
            }
        }
        if(split==' '){
            return right-left+1;
        }
        int pointer=left;
        int ret=0;
        while(pointer<=right){
            while(pointer<=right&&s.charAt(pointer)==split){
                pointer++;
            }
            if(pointer>right){
                break;
            }
            int start=pointer;
            while(pointer<=right&&s.charAt(pointer)!=split){
                pointer++;
            }
            int end=pointer-1;
            ret=Math.max(ret,dfs(s,start,end,k));
        }
        return ret;
    }
}