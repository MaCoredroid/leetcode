class Solution {
    public boolean rotateString(String s, String goal) {
        char[] ch1=s.toCharArray();
        char[] ch2=goal.toCharArray();
        if(ch1.length!=ch2.length){
            return false;
        }
        if(ch1.length==0){
            return true;
        }
        int pointer1=0,pointer2=0;
        while(pointer2<ch2.length){
            while(pointer2<ch2.length&&ch2[pointer2]!=ch1[pointer1]){
                pointer2++;
            }
            if(check(ch1,ch2,pointer2)){
                return true;
            }
            pointer2++;
        }
        return false;
    }

    private boolean check(char[] ch1,char[] ch2,int pointer2){
        int p=0;
        while(pointer2<ch2.length&&ch1[p]==ch2[pointer2]){
            p++;
            pointer2++;
        }
        if(pointer2!=ch2.length){
            return false;
        }
        int p2=0;
        while(p<ch1.length&&ch1[p]==ch2[p2]){
            p++;
            p2++;
        }
        return p==ch1.length;

    }
}