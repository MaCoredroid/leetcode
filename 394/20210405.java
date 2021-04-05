class Solution {
    public String decodeString(String s) {
        char[] ch=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='0'&&ch[i]<='9'){
                count=count*10+ch[i]-'0';
            }else if(ch[i]=='['){
                int j=i+1;
                int num=0;
                while(j<ch.length){
                    if(ch[j]=='['){
                        num++;
                    }else if(ch[j]==']'){
                        if(num==0){
                            break;
                        }else{
                            num--;
                        }
                    }
                    j++;
                }
                String inner=decodeString(s.substring(i+1,j));
                for(int p=0;p<count;p++){
                    sb.append(inner);
                }
                count=0;
                i=j;
            }else{
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}