class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int p1=0,p2=0;
        while(p1<word.length()&&p2<abbr.length()){
            if(word.charAt(p1)==abbr.charAt(p2)){
                p1++;
                p2++;
            }else{
                if(abbr.charAt(p2)=='0'||Character.isLetter(abbr.charAt(p2))){
                    return false;
                }
                int num=0;
                while(p2<abbr.length()&&abbr.charAt(p2)>='0'&&abbr.charAt(p2)<='9'){
                    num=num*10+abbr.charAt(p2++)-'0';
                }
                p1+=num;
            }
            
        }
        return p1==word.length()&&p2==abbr.length();
    }
}