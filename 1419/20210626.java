class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c=0;
        int r=0;
        int o=0;
        int a=0;
        int k=0;
        int res=0;
        for(char ch:croakOfFrogs.toCharArray()){
            if(ch=='c'){
                if(k==0){
                    res++;
                }else{
                    k--;
                }
                c++;
            }else if(ch=='r'){
                c--;
                r++;
            }else if(ch=='o'){
                r--;
                o++;
            }else if(ch=='a'){
                o--;
                a++;
            }else{
                a--;
                k++;
            }
            if(c<0||r<0||o<0||a<0){
                return -1;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0)
        {
            return -1;
        }
        return res;
    }
}