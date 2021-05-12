class Solution {
    public int maximumSwap(int num) {
        String s= String.valueOf(num);
        char[] ch=s.toCharArray();
        int[] res=new int[10];
        for(int i=0;i<ch.length;i++){
            res[ch[i]-'0']=i;
        }
        for(int i=0;i<ch.length;i++){
            for(int d=9;d>ch[i]-'0';d--){
                if(res[d]>i){
                    char temp=ch[i];
                    ch[i]=ch[res[d]];
                    ch[res[d]]=temp;
                    return Integer.parseInt(new String(ch));
                }
            }
        }
        return num;
    }
}