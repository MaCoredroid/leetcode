class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] ch1=s.toCharArray();
        char[] ch2=t.toCharArray();
        int p=0;
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]=='#'){
                if(p>0){
                    p--;
                }
            }else{
                ch1[p++]=ch1[i];
            }
        }
        int q=0;
        for(int i=0;i<ch2.length;i++){
            if(ch2[i]=='#'){
                if(q>0){
                    q--;
                }
            }else{
                ch2[q++]=ch2[i];
            }
        }
        if(p!=q){
            return false;
        }
        for(int i=0;i<p;i++){
            if(ch1[i]!=ch2[i]){
                return false;
            }
        }
        return true;
    }
}