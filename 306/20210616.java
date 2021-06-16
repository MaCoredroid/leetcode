class Solution {
    public boolean isAdditiveNumber(String num) {
        char[] ch=num.toCharArray();
        for(int i=1;i<=ch.length-2;i++){
            if(ch[0]=='0'&&i>1){
                break;
            }
            for(int j=i+1;j<=ch.length-1;j++){
                Long a=Long.parseLong(new String(ch,0,i));
                if(ch[i]=='0'&&j>i+1){
                    break;
                }
                Long b=Long.parseLong(new String(ch,i,j-i));
                int p=j;
                boolean flag=true;
                while(p<ch.length){
                    long temp=b;
                    b+=a;
                    a=temp;
                    String next=Long.toString(b);
                    int k=0;
                    while(k<next.length()&&p<ch.length){
                        if(next.charAt(k)!=ch[p]){
                            break;
                        }
                        k++;
                        p++;
                    }
                    if(k!=next.length()){
                        flag=false;
                        break;
                    }
                }
                if(flag&&p==ch.length){
                    return true;
                }
            }
        }
        return false;
    }
}