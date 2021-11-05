class Solution {
    public boolean isNumber(String s) {
        boolean isNum=false,isE=false,isDot=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='+'||c=='-'){
                if(i>0&&s.charAt(i-1)!='e'&&s.charAt(i-1)!='E'){
                    return false;
                }
            }else if(c=='.'){
                if(isDot||isE){
                    return false;
                }
                isDot=true;
            }else if(c=='e'||c=='E'){
                if(isE||!isNum){
                    return false;
                }
                isE=true;
                isNum=false;
            }else if(c>='0'&&c<='9'){
                isNum=true;
            }else{
                return false;
            }
        }
        return isNum;
    }
}