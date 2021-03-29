class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String ans=strs[0];
        for(int i=1;i<strs.length;i++){
            ans=commonInTwo(ans,strs[i]);
        }
        return ans;
        

    }

    private String commonInTwo(String a,String b){
        int index=Math.min(a.length(),b.length());
        int i=0;
        while(i<index){
            if(a.charAt(i)!=b.charAt(i)){
                break;
            }
            i++;
        }
        return a.substring(0,i);
    }
}