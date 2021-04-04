class Solution {
    public boolean isNumber(String s) {
        s=s.trim();
        char[] ch=s.toCharArray();
        boolean hasNumber=false;
        boolean hasSign=false;
        boolean hasE=false;
        boolean hasPoint=false;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='-'||ch[i]=='+'){
                if(hasSign||hasNumber||hasPoint){
                    return false;
                }
                hasSign=true;
            }else if(ch[i]=='e'||ch[i]=='E'){
                if(hasE||!hasNumber){
                    return false;
                }
                hasE=true;
                hasNumber=false;
                hasSign=false;
                hasPoint=false;
            }else if(ch[i]=='.'){
                if(hasPoint||hasE){
                    return false;
                }
                hasPoint=true;
            }else if(ch[i]>='0'&&ch[i]<='9'){
                hasNumber=true;
            }else{
                return false;
            }
        }
        return hasNumber;
        
    }
}