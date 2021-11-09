class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int p1=0,p2=0;
        int prev=0;
        boolean leadingZero=true;
        while(p1<word.length()&&p2<abbr.length()){
            if(abbr.charAt(p2)>='0'&&abbr.charAt(p2)<='9'){
                if(abbr.charAt(p2)=='0'){
                    if(leadingZero){
                        return false;
                    }
                }else{
                    leadingZero=false;
                }
                prev=prev*10+abbr.charAt(p2)-'0';
                p2++;
            }else{
                if(prev!=0){
                    p1+=prev;
                    prev=0;
                    leadingZero=true;
                }
                if(p1<word.length()&&word.charAt(p1)==abbr.charAt(p2)){
                    p1++;
                    p2++;
                }else{
                    return false;
                }
            }
        }
        return p1+prev==word.length()&&p2==abbr.length();
    }
}