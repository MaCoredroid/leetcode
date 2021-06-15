class Solution {
    public boolean patternMatching(String pattern, String value) {
        int cnta=0,cntb=0;
        for(char ch:pattern.toCharArray()){
            if(ch=='a'){
                cnta++;
            }else{
                cntb++;
            }
        }
        if(cnta<cntb){
            int temp=cnta;
            cnta=cntb;
            cntb=temp;
            char[] ch=pattern.toCharArray();
            for(int i=0;i<ch.length;i++){
                ch[i]=(ch[i]=='a'?'b':'a');
            }
            pattern=new String(ch);
        }
        if(value.length()==0){
            return cntb==0;
        }
        if(pattern.length()==0){
            return false;
        }
        for(int len_a=0;cnta*len_a<=value.length();len_a++){
            int rest=value.length()-cnta*len_a;
            if((cntb==0&&rest==0)||(cntb!=0&&rest%cntb==0)){
                int len_b=(cntb==0?0:rest/cntb);
                int pos=0;
                boolean correct=true;
                String value_a="",value_b="";
                for(char ch:pattern.toCharArray()){
                    if (ch == 'a') {
                        String sub=value.substring(pos,pos+len_a);
                        if(value_a.length()==0){
                            value_a=sub;
                        }else if(!value_a.equals(sub)){
                            correct=false;
                            break;
                        }
                        pos+=len_a;
                    }else{
                        String sub=value.substring(pos,pos+len_b);
                        if(value_b.length()==0){
                            value_b=sub;
                        }else if(!value_b.equals(sub)){
                            correct=false;
                            break;
                        }
                        pos+=len_b;
                    }
                }
                if(correct&&!value_a.equals(value_b)){
                    return true;
                }
            }
        }
        return false;
    }
}