class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        int pointer=0;
        while(true){
            char c='a';
            for(int i=0;i<strs.length;i++){
                if(pointer>=strs[i].length()){
                    return sb.toString();
                }
                if(i==0){
                    c=strs[i].charAt(pointer);
                }else{
                    if(c!=strs[i].charAt(pointer)){
                        return sb.toString();
                    }
                }
            }
            sb.append(c);
            pointer++;
        }
        

    }
}