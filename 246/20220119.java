class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] ch=num.toCharArray();
        int i=0,j=ch.length-1;
        while(i<=j){
            if(!check(ch[i]-'0',ch[j]-'0')){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean check(int a,int b){
        return (a==8&&b==8)||(a==6&&b==9)||(a==9&&b==6)||(a==1&&b==1)||(a==0&&b==0);
    }
}