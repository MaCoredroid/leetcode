class Solution {
    
    public int countVowelStrings(int n) {
        int a=1,b=1,c=1,d=1,e=1;
        for(int i=0;i<n-1;i++){
            b+=a;
            c+=b;
            d+=c;
            e+=d;
        }
        return a+b+c+d+e;
    }

    
}